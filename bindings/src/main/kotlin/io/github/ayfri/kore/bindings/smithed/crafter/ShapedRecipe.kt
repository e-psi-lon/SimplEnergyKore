package io.github.ayfri.kore.bindings.smithed.crafter

import io.github.ayfri.kore.arguments.ItemSlotType
import io.github.ayfri.kore.arguments.maths.Vec3
import io.github.ayfri.kore.arguments.maths.vec3
import io.github.ayfri.kore.arguments.selector.scores
import io.github.ayfri.kore.arguments.types.literals.int
import io.github.ayfri.kore.arguments.types.literals.literal
import io.github.ayfri.kore.arguments.types.literals.self
import io.github.ayfri.kore.bindings.utils.CustomItemArgument
import io.github.ayfri.kore.bindings.smithed.Smithed
import io.github.ayfri.kore.commands.execute.execute
import io.github.ayfri.kore.commands.loot
import io.github.ayfri.kore.functions.Function
import io.github.ayfri.kore.commands.Target
import kotlinx.serialization.encodeToString



class ShapedRecipe: Recipe {
    override var result: CustomItemArgument? = null
    private val pattern: MutableList<MutableList<Char>> = mutableListOf()
    private val keys: MutableMap<Char, Item?> = mutableMapOf()

    fun pattern(vararg rows: String) {
        pattern.clear()
        for (row in rows) {
            if (row.length < 3) {
                throw IllegalArgumentException("Row must be at least 3 characters long.")
            }
            val items = row.toMutableList()
            pattern.add(items)
        }
    }

    fun key(key: Char, item: Item) {
        if (!pattern.flatten().contains(key)) {
            throw IllegalArgumentException("Pattern does not contain $key.")
        }
        keys[key] = item
    }

    fun result(item: CustomItemArgument) {
        result = item
    }

    context(Function)
    override fun build() {
        if (result == null) {
            throw IllegalArgumentException("Result must be set.")
        }
        if (pattern.isEmpty()) {
            throw IllegalArgumentException("Pattern must be set.")
        }
        if (keys.isEmpty()) {
            throw IllegalArgumentException("Keys must be set.")
        }
        val items = mutableListOf(
            mutableListOf<Item?>(),
            mutableListOf(),
            mutableListOf()
        )
        for ((index, row) in pattern.withIndex()) {
            if (row.size < 3) {
                throw IllegalArgumentException("Row must be at least 3 characters long.")
            }
            for ((index2, char) in row.withIndex()) {
                if (keys[char] == null) {
                    throw IllegalArgumentException("Key $char is not set.")
                }
                if (char != ' ') {
                    items[index].add(keys[char]?.addSlot(index2))
                }
            }
        }
        if (items.flatten().contains(null)) {
            throw IllegalArgumentException("Some slots are not set.")
        }

        execute {
            storeResult {
                Smithed.data(self())
            }
            ifCondition {
                entity(
                    self {
                        scores {
                            Smithed.data() equalTo 0
                        }
                    }
                )
            }

            ifCondition {
                val recipe = items.mapIndexed { index, list ->
                    index.toString() to list.map { it!! }
                }.toMap()
                data(Crafter.input(), "{recipe:${snbt.encodeToString(recipe)}}")
            }

            run {
                loot {
                    target {
                        replaceBlock2(vec3(), ItemSlotType.invoke { "container.16" })
                    }
                    source {
                        loot(result!!.lootTable)
                    }
                }
            }
        }

    }
}

fun Target.replaceBlock2(pos: Vec3, slot: ItemSlotType, count: Int? = null) = listOfNotNull(literal("replace"), literal("block"), pos, slot,
    count?.let { int(it) })
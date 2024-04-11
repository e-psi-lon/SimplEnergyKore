package simplenergy

import io.github.ayfri.kore.bindings.utils.CustomItemArgument
import io.github.ayfri.kore.arguments.components.Components
import io.github.ayfri.kore.arguments.components.CustomDataComponent
import io.github.ayfri.kore.arguments.components.blockEntityData
import io.github.ayfri.kore.arguments.components.customData
import io.github.ayfri.kore.arguments.types.resources.ItemArgument
import io.github.ayfri.kore.arguments.types.resources.LootTableArgument
import io.github.ayfri.kore.generated.Blocks
import net.benwoodworth.knbt.*

interface SimplEnergyItemArgument: CustomItemArgument {

    override operator fun invoke(block: Components.() -> Unit): SimplEnergyItemArgument {
        return SimplEnergyItemArgument(name, namespace, lootTable, baseItem).apply {
            components = baseItem.components?.apply(block)
            components = initializeComponents()
        }
    }

    override fun initializeComponents(): Components? {
        return baseItem.components?.apply {
            if (baseItem.name == "barrel" && baseItem.components?.get("block_entity_data") == null) {
                blockEntityData(Blocks.BARREL) {
                    putNbtList("Items") {
                        addNbtCompound {
                            put("id", "minecraft:stone")
                            put("Count", 1.toByte())
                            put("Slot", 0.toByte())
                            putNbtCompound("tag") {
                                putNbtCompound("smithed") {
                                    put("from", "simplenergy")
                                    put("id", "simplenergy:simplunium_ore")
                                }
                            }
                        }
                    }
                }
            }
            customData {
                if (get("simplenergy") == null) {
                    putNbtCompound("simplenergy") {
                        put(name.lowercase(), true)
                    }
                }
                val current = ((get("smithed") as CustomDataComponent?)?.nbt as NbtCompound?)
                putNbtCompound("smithed") {
                    put("from", "stoupy:simplenergy")
                    put("id", "$namespace:${name.lowercase()}")
                    if (current != null) {
                        for (key in current.keys) {
                            current[key]?.let { put(key, it) }
                        }
                    }
                }
            }
        }
    }

    companion object {
        operator fun invoke(name: String, namespace: String, lootTableArgument: LootTableArgument, baseItem: ItemArgument): SimplEnergyItemArgument {
            return object : SimplEnergyItemArgument {
                override val baseItem = baseItem
                override val namespace = namespace
                override val name: String = name
                override val lootTable = lootTableArgument
            }.apply { components = initializeComponents() }
        }
    }
}
package simplenergy

import io.github.ayfri.kore.arguments.components.Components
import io.github.ayfri.kore.arguments.components.customData
import io.github.ayfri.kore.arguments.components.customModelData
import io.github.ayfri.kore.arguments.types.resources.ItemArgument
import io.github.ayfri.kore.arguments.types.resources.LootTableArgument
import io.github.ayfri.kore.generated.Items
import net.benwoodworth.knbt.*



enum class SimplEnergyItems: SimplEnergyItemArgument {
    SIMPLUNIUM_ORE {
        override val baseItem = Items.BARREL {
            customData {
                putNbtCompound("ctc") {
                    put("from", "stoupy:simplenergy")
                }
                putNbtCompound("smithed") {
                    put("id", "simplenergy:simplunium_ore")
                    put("from", "stoupy:simplenergy")
                    putNbtCompound("ignore") {
                        put("functionality", true)
                        put("crafting", true)
                    }
                    putNbtCompound("dict") {
                        putNbtCompound("ore") {
                            put("simplunium", true)
                        }
                        putNbtCompound("block") {
                            put("simplunium", true)
                        }
                    }
                }
            }
            customModelData(2012000)
        }
        override val namespace: String
            get() = "simplenergy"
        override val lootTable: LootTableArgument
            get() = LootTableArgument("i/${name.lowercase()}", namespace)
    },
    DEEPSLATE_SIMPLUNIUM_ORE {
        override val baseItem = Items.BARREL {
            customData {
                putNbtCompound("ctc") {
                    put("from", "stoupy:simplenergy")
                }
                putNbtCompound("smithed") {
                    put("id", "simplenergy:deepslate_simplunium_ore")
                    put("from", "stoupy:simplenergy")
                    putNbtCompound("ignore") {
                        put("functionality", true)
                        put("crafting", true)
                    }
                    putNbtCompound("dict") {
                        putNbtCompound("ore") {
                            put("simplunium", true)
                        }
                        putNbtCompound("block") {
                            put("simplunium", true)
                        }
                    }
                }
            }
            customModelData(2012001)
        }
        override val namespace: String
            get() = "simplenergy"
        override val lootTable: LootTableArgument
            get() = LootTableArgument("i/${name.lowercase()}", namespace)
    },
}

enum class SimplEnergyItemTags: ItemArgument {
    ITEMS {
        override var components: Components? = Components().apply {
            customData {
                putNbtCompound("ctc") {
                    put("from", "stoupy:simplenergy")
                }
            }
        }
        override val namespace: String
            get() = "simplenergy"

        override fun asId(): String {
            return "items"
        }

        override fun asString(): String {
            return "#$namespace:${asId()}${components?.toString() ?: ""}"
        }

        override fun invoke(block: Components.() -> Unit): ItemArgument {
            components?.block()
            return this
        }
    },
}

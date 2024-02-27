package simplenergy


import io.github.ayfri.kore.DataPack
import io.github.ayfri.kore.arguments.chatcomponents.scoreComponent
import io.github.ayfri.kore.arguments.chatcomponents.textComponent
import io.github.ayfri.kore.arguments.colors.Color
import io.github.ayfri.kore.arguments.maths.vec3
import io.github.ayfri.kore.arguments.scores.score
import io.github.ayfri.kore.arguments.selector.scores
import io.github.ayfri.kore.arguments.types.literals.*
import io.github.ayfri.kore.arguments.types.resources.ItemArgument
import io.github.ayfri.kore.arguments.types.resources.LootTableArgument
import io.github.ayfri.kore.arguments.types.resources.storage
import io.github.ayfri.kore.commands.*
import io.github.ayfri.kore.commands.execute.execute
import io.github.ayfri.kore.commands.scoreboard.scoreboard
import io.github.ayfri.kore.functions.function
import net.benwoodworth.knbt.*


context(DataPack)
fun simpleEnergyFunction() {
    function("manual", "simplenergy") {
        data(storage("manual", "simplenergy")) {
            modify(
                "Item.tag.pages", """
            ['["",{"text":"\\uec02","color":"white","font":"simplenergy:font"},{"text":"\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\n\\uec01\\uec01","color":"white","font":"simplenergy:font"},{"text":"SimplEnergy Wiki","underlined":true,"color":"blue","clickEvent":{"action":"open_url","value":"https://energy-datapacks.fandom.com/wiki/"}}]','[{"text":"\\uec03","color":"white","font":"simplenergy:font"},{"text":"\\n\\n\\n\\uec01"},{"text":"\\uec00","clickEvent":{"action":"change_page","value":3},"hoverEvent":{"action":"show_text","contents":[{"text":"Heavy Workbench","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":4},"hoverEvent":{"action":"show_text","contents":[{"text":"SimplEnergy Manual","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":5},"hoverEvent":{"action":"show_text","contents":[{"text":"Cauldron Generator","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":6},"hoverEvent":{"action":"show_text","contents":[{"text":"Furnace Generator","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":7},"hoverEvent":{"action":"show_text","contents":[{"text":"Solar Panel","italic":false,"color":"white"}]}},{"text":"\\n\\uec01","color":"reset"},{"text":"\\uec00","clickEvent":{"action":"change_page","value":3},"hoverEvent":{"action":"show_text","contents":[{"text":"Heavy Workbench","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":4},"hoverEvent":{"action":"show_text","contents":[{"text":"SimplEnergy Manual","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":5},"hoverEvent":{"action":"show_text","contents":[{"text":"Cauldron Generator","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":6},"hoverEvent":{"action":"show_text","contents":[{"text":"Furnace Generator","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":7},"hoverEvent":{"action":"show_text","contents":[{"text":"Solar Panel","italic":false,"color":"white"}]}},{"text":"\\n\\uec01","color":"reset"},{"text":"\\uec00","clickEvent":{"action":"change_page","value":8},"hoverEvent":{"action":"show_text","contents":[{"text":"Simple Battery","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":9},"hoverEvent":{"action":"show_text","contents":[{"text":"Advanced Battery","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":10},"hoverEvent":{"action":"show_text","contents":[{"text":"Elite Battery","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":11},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Furnace","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":12},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Smelter","italic":false,"color":"white"}]}},{"text":"\\n\\uec01","color":"reset"},{"text":"\\uec00","clickEvent":{"action":"change_page","value":8},"hoverEvent":{"action":"show_text","contents":[{"text":"Simple Battery","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":9},"hoverEvent":{"action":"show_text","contents":[{"text":"Advanced Battery","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":10},"hoverEvent":{"action":"show_text","contents":[{"text":"Elite Battery","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":11},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Furnace","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":12},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Smelter","italic":false,"color":"white"}]}},{"text":"\\n\\uec01","color":"reset"},{"text":"\\uec00","clickEvent":{"action":"change_page","value":13},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Brewing Stand","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":14},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Lamp","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":15},"hoverEvent":{"action":"show_text","contents":[{"text":"Simple Cable","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":16},"hoverEvent":{"action":"show_text","contents":[{"text":"Advanced Cable","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":17},"hoverEvent":{"action":"show_text","contents":[{"text":"Elite Cable","italic":false,"color":"white"}]}},{"text":"\\n\\uec01","color":"reset"},{"text":"\\uec00","clickEvent":{"action":"change_page","value":13},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Brewing Stand","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":14},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Lamp","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":15},"hoverEvent":{"action":"show_text","contents":[{"text":"Simple Cable","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":16},"hoverEvent":{"action":"show_text","contents":[{"text":"Advanced Cable","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":17},"hoverEvent":{"action":"show_text","contents":[{"text":"Elite Cable","italic":false,"color":"white"}]}},{"text":"\\n\\uec01","color":"reset"},{"text":"\\uec00","clickEvent":{"action":"change_page","value":13},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Brewing Stand","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":14},"hoverEvent":{"action":"show_text","contents":[{"text":"Electric Lamp","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":15},"hoverEvent":{"action":"show_text","contents":[{"text":"Simple Cable","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":16},"hoverEvent":{"action":"show_text","contents":[{"text":"Advanced Cable","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":17},"hoverEvent":{"action":"show_text","contents":[{"text":"Elite Cable","italic":false,"color":"white"}]}},{"text":"\\n\\uec01","color":"reset"},{"text":"\\uec00","clickEvent":{"action":"change_page","value":18},"hoverEvent":{"action":"show_text","contents":[{"text":"Simplunium Ore","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":19},"hoverEvent":{"action":"show_text","contents":[{"text":"Simplunium Equipments","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":20},"hoverEvent":{"action":"show_text","contents":[{"text":"Multimeter","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":21},"hoverEvent":{"action":"show_text","contents":[{"text":"Wrench","italic":false,"color":"white"}]}},{"text":"\\n\\uec01","color":"reset"},{"text":"\\uec00","clickEvent":{"action":"change_page","value":18},"hoverEvent":{"action":"show_text","contents":[{"text":"Simplunium Ore","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":19},"hoverEvent":{"action":"show_text","contents":[{"text":"Simplunium Equipments","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":20},"hoverEvent":{"action":"show_text","contents":[{"text":"Multimeter","italic":false,"color":"white"}]}},{"text":"\\uec00","clickEvent":{"action":"change_page","value":21},"hoverEvent":{"action":"show_text","contents":[{"text":"Wrench","italic":false,"color":"white"}]}}]','{"text":"\\uec04","color":"white","font":"simplenergy:font"}','{"text":"\\uec05","color":"white","font":"simplenergy:font"}','{"text":"\\uec06","color":"white","font":"simplenergy:font"}','{"text":"\\uec07","color":"white","font":"simplenergy:font"}','{"text":"\\uec08","color":"white","font":"simplenergy:font"}','{"text":"\\uec09","color":"white","font":"simplenergy:font"}','{"text":"\\uec0A","color":"white","font":"simplenergy:font"}','{"text":"\\uec0B","color":"white","font":"simplenergy:font"}','{"text":"\\uec0C","color":"white","font":"simplenergy:font"}','{"text":"\\uec0D","color":"white","font":"simplenergy:font"}','{"text":"\\uec0E","color":"white","font":"simplenergy:font"}','{"text":"\\uec0F","color":"white","font":"simplenergy:font"}','{"text":"\\uec10","color":"white","font":"simplenergy:font"}','{"text":"\\uec11","color":"white","font":"simplenergy:font"}','{"text":"\\uec12","color":"white","font":"simplenergy:font"}','{"text":"\\uec13","color":"white","font":"simplenergy:font"}','{"text":"\\uec14","color":"white","font":"simplenergy:font"}','{"text":"\\uec15","color":"white","font":"simplenergy:font"}','{"text":"\\uec16","color":"white","font":"simplenergy:font"}']
        """.trimIndent()
            )
        }
    }

    function("_give", "simplenergy") {
        loot(self(), LootTableArgument.invoke("i/simplunium_ore", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/deepslate_simplunium_ore", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/raw_simplunium_block", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_block", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/raw_simplunium", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_ingot", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_nugget", "simplenergy"))
        addBlankLine()
        loot(self(), LootTableArgument.invoke("i/simplenergy_manual", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_helmet", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_chestplate", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_leggings", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_boots", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_sword", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_pickaxe", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_axe", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_hoe", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/simplunium_shovel", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/multimeter", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/wrench", "simplenergy"))
        addBlankLine()
        loot(self(), LootTableArgument.invoke("i/simple_battery", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/advanced_battery", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/elite_battery", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/elite_creative_battery", "simplenergy"))
        addBlankLine()
        loot(self(), LootTableArgument.invoke("i/cauldron_generator", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/furnace_generator", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/solar_panel", "simplenergy"))
        addBlankLine()
        loot(self(), LootTableArgument.invoke("i/electric_furnace", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/electric_smelter", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/electric_lamp", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/electric_brewing_stand", "simplenergy"))
        addBlankLine()
        loot(self(), LootTableArgument.invoke("i/simple_cable", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/advanced_cable", "simplenergy"))
        loot(self(), LootTableArgument.invoke("i/elite_cable", "simplenergy"))
    }

    function("_stats", "simplenergy") {
        addBlankLine()
        tellraw(self(), textComponent("\n[Datapack Energy Stats]", Color.YELLOW))
        addBlankLine()
        execute {
            storeResult {
                score(literal("#temp"), "simplenergy.data")
            }
            ifCondition {
                entity(allEntities {
                    scores {
                        score("energy.transfer_rate") greaterThan 0
                    }
                })
            }
        }
        tellraw(self(), textComponent("Entities: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        addBlankLine()
        execute {
            storeResult {
                score(literal("#temp"), "simplenergy.data")
            }
            ifCondition {
                entity(allEntities {
                    scores {
                        score("energy.transfer_rate") greaterThan 0
                    }
                    tag = "energy.cable"
                })
            }
        }
        tellraw(self(), textComponent("Cables: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        addBlankLine()
        execute {
            storeResult {
                score(literal("#temp"), "simplenergy.data")
            }
            ifCondition {
                entity(allEntities {
                    scores {
                        score("energy.transfer_rate") greaterThan 0
                    }
                    tag = "!energy.cable"
                })
            }
        }
        tellraw(self(), textComponent("Devices: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        addBlankLine()
        execute {
            storeResult {
                score(literal("#temp"), "simplenergy.data")
            }
            ifCondition {
                entity(allEntities {
                    scores {
                        score("energy.transfer_rate") greaterThan 0
                    }
                    tag = "energy.send, tag=!energy.receive"
                })
            }
        }
        tellraw(self(), textComponent("Only energy.send: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        addBlankLine()
        execute {
            storeResult {
                score(literal("#temp"), "simplenergy.data")
            }
            ifCondition {
                entity(allEntities {
                    scores {
                        score("energy.transfer_rate") greaterThan 0
                    }
                    tag = "energy.receive, tag=!energy.send"
                })
            }
        }
        tellraw(self(), textComponent("Only energy.receive: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        addBlankLine()
        execute {
            storeResult {
                score(literal("#temp"), "simplenergy.data")
            }
            ifCondition {
                entity(allEntities {
                    scores {
                        score("energy.transfer_rate") greaterThan 0
                    }
                    tag = "energy.send, tag=energy.receive"
                })
            }
        }
        tellraw(self(), textComponent("Send & Receive: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        addBlankLine()
        addBlankLine()
        addBlankLine()
        tellraw(self(), textComponent("\n[SimplEnergy Stats]", Color.GREEN))
        addBlankLine()
        execute {
            storeResult {
                score(literal("#temp"), "simplenergy.data")
            }
            ifCondition {
                entity(allEntities {
                    tag = "simplenergy.destroyer"
                })
            }
        }
        tellraw(self(), textComponent("Custom blocks loaded: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        addBlankLine()
        execute {
            storeResult {
                score(literal("#temp"), "simplenergy.data")
            }
            ifCondition {
                entity(allEntities {
                    tag = "simplenergy.ore"
                })
            }
        }
        tellraw(self(), textComponent("Custom ores:", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        addBlankLine()
        execute {
            storeResult {
                score(literal("#temp"), "simplenergy.data")
            }
            ifCondition {
                entity(allEntities {
                    tag = "furnace_nbt_recipes.furnace"
                    }
                )
            }
        }
        tellraw(self(), textComponent("Markers on furnaces: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        addBlankLine()
        scoreboard {
            players {
                reset(literal("#temp"), "simplenergy.data")
            }
        }

    }

    function("uninstall", "simplenergy") {
        scoreboard {
            objectives {
                remove("simplenergy.data")
            }
        }
        scoreboard {
            objectives {
                remove("simplenergy.timer_data")
            }
        }
        scoreboard {
            objectives {
                remove("simplenergy.right_click")
            }
        }
        addBlankLine()
        data(storage("main", "simplenergy")) {
            remove("all")
        }
        data(storage("temp", "simplenergy")) {
            remove("all")
        }
        data(storage("inventory", "simplenergy")) {
            remove("all")
        }
        data(storage("manual", "simplenergy")) {
            remove("Item")
        }
        tp(allEntities { tag = "simplenergy.destroyer" }, vec3(0, -10000, 0))
        kill(allEntities { tag = "simplenergy.destroyer" })
        addBlankLine()
        clear(allPlayers(), ItemArgument.invoke(
            "items", "#simplenergy",
            mapOf("ctc" to mapOf("from" to "stoupy:simplenergy")).toNbtCompound()
        ))
        addBlankLine()
        tellraw(self(), textComponent("You can now disable SimplEnergy or delete it of your datapack folder.", Color.GREEN))
    }

}

fun Map<*, *>.toNbtCompound(): NbtCompound {
    val valuesAsCompound = mapValues { (_, value) ->
        when (value) {
            is Map<*, *> -> value.toNbtCompound()
            is String -> NbtString(value)
            is Int -> NbtInt(value)
            else -> NbtString(value.toString())
        }
    }
    val keysAsStrings = valuesAsCompound.mapKeys { (key, _) -> key.toString() }
    return NbtCompound(keysAsStrings)
}

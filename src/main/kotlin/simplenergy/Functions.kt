package simplenergy


import io.github.ayfri.kore.bindings.energy.Energy
import io.github.ayfri.kore.DataPack
import io.github.ayfri.kore.arguments.chatcomponents.scoreComponent
import io.github.ayfri.kore.arguments.chatcomponents.textComponent
import io.github.ayfri.kore.arguments.colors.Color
import io.github.ayfri.kore.arguments.maths.vec3
import io.github.ayfri.kore.arguments.selector.scores
import io.github.ayfri.kore.arguments.types.literals.*
import io.github.ayfri.kore.arguments.types.resources.LootTableArgument
import io.github.ayfri.kore.arguments.types.resources.storage
import io.github.ayfri.kore.commands.*
import io.github.ayfri.kore.commands.execute.ExecuteCondition
import io.github.ayfri.kore.commands.execute.execute
import io.github.ayfri.kore.commands.scoreboard.scoreboard
import io.github.ayfri.kore.functions.Function
import io.github.ayfri.kore.functions.function


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
        for (item in SimplEnergyItems.entries) {
            loot(self(), LootTableArgument.invoke("i/${item.name}", item.namespace))
        }
    }

    function("_stats", "simplenergy") {
        tellraw(self(), textComponent("\n[Datapack Energy Stats]", Color.YELLOW))
        storeToTemp("simplenergy.data") {
            entity(allEntities {
                scores {
                    Energy.transferRate() greaterThan 0
                }
            })
        }
        tellraw(self(), textComponent("Entities: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        storeToTemp("simplenergy.data") {
            entity(allEntities {
                scores {
                    Energy.transferRate() greaterThan 0
                }
            })
        }
        tellraw(self(), textComponent("Cables: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        storeToTemp("simplenergy.data") {
            entity(Energy.cable(allEntities {
                scores {
                    Energy.transferRate() greaterThan 0
                }
            }, true))
        }
        tellraw(self(), textComponent("Devices: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        storeToTemp("simplenergy.data") {
            entity(Energy.sender(allEntities {
                scores {
                    Energy.transferRate() greaterThan 0
                }
            }))
        }
        tellraw(self(), textComponent("Only energy.send: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        storeToTemp("simplenergy.data") {
            entity(Energy.receiver(allEntities {
                scores {
                    Energy.transferRate() greaterThan 0
                }
            }))
        }
        tellraw(self(), textComponent("Only energy.receive: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        storeToTemp("simplenergy.data") {
            entity(Energy.senderAndReceiver(allEntities {
                scores {
                    Energy.transferRate() greaterThan 0
                }
            }))
        }
        tellraw(self(), textComponent("Send & Receive: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        tellraw(self(), textComponent("\n[SimplEnergy Stats]", Color.GREEN))
        storeToTemp("simplenergy.data") {
            entity(allEntities {
                tag = "simplenergy.destroyer"
            })
        }
        tellraw(self(), textComponent("Custom blocks loaded: ", Color.GRAY) + scoreComponent("simplenergy.data", literal("#temp")) { color = Color.GOLD })
        storeToTemp("simplenergy.data") {
            entity(allEntities {
                tag = "simplenergy.ore"
            })
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
        clear(allPlayers(), SimplEnergyItemTags.ITEMS)
        tellraw(self(), textComponent("You can now disable SimplEnergy or delete it of your datapack folder.", Color.GREEN))
    }

}
context(Function)
fun storeToTemp(objective: String, condition: ExecuteCondition.() -> Unit) {
    execute {
        storeResult {
            score(literal("#temp"), objective)
        }
        ifCondition(condition)
    }
}

import io.github.ayfri.kore.arguments.chatcomponents.*
import io.github.ayfri.kore.bindings.smithed.Smithed
import io.github.ayfri.kore.bindings.smithed.actionbar.ActionBar
import io.github.ayfri.kore.bindings.smithed.actionbar.Message
import io.github.ayfri.kore.bindings.smithed.actionbar.MessagePriority
import io.github.ayfri.kore.bindings.smithed.crafter.Item
import io.github.ayfri.kore.commands.say
import io.github.ayfri.kore.dataPack
import io.github.ayfri.kore.functions.function
import io.github.ayfri.kore.pack.pack
import simplenergy.SimplEnergyItems
import simplenergy.simpleEnergyFunction
import kotlin.io.path.Path

fun main() {
    val datapack = dataPack("simplenergy") {
        pack  {
            description = textComponent("SimplEnergy")
            format = 18
        }
        simpleEnergyFunction()
        path = Path("C:\\Users\\lilia\\AppData\\Roaming\\.multimc\\instances\\1.20.2\\.minecraft\\saves\\SimplEnergyKore\\datapacks")
        Smithed.crafter.recipes("simplenergy") {
            shapedRecipe {
                pattern(
                    "###",
                    "#I#",
                    "###"
                )
                key('#', Item(id="minecraft:stone"))
                key('I', Item(id="minecraft:iron_ingot"))
                result(SimplEnergyItems.SIMPLUNIUM_ORE)
            }

            shapelessRecipe {
                ingredient(Item(id="minecraft:stone", count=1))
                ingredient(Item(id="minecraft:iron_ingot", count=1))
                result(SimplEnergyItems.SIMPLUNIUM_ORE)
            }
        }
        function("test") {
            ActionBar.send(Message(raw = "Hello, world!", priority = MessagePriority.CONDITIONAL))
        }

        Smithed.actionBar.onClickLockedContainer("simplenergy") {
            say("Hello, world!")
        }


    }

    datapack.generate()
}
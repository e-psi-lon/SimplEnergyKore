import io.github.ayfri.kore.arguments.chatcomponents.*
import io.github.ayfri.kore.dataPack
import io.github.ayfri.kore.pack.pack
import simplenergy.simpleEnergyFunction

fun main() {
    val datapack = dataPack("simplenergy") {
        pack  {
            description = textComponent("SimplEnergy")
            format = 32
        }
        simpleEnergyFunction()
    }
    datapack.generate()
}
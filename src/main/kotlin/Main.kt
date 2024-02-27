import io.github.ayfri.kore.arguments.chatcomponents.*
import io.github.ayfri.kore.dataPack
import io.github.ayfri.kore.pack.pack
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
    }
    datapack.generate()
}
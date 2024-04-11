package io.github.ayfri.kore.bindings.smithed.custom_block

import io.github.ayfri.kore.DataPack
import io.github.ayfri.kore.arguments.types.resources.storage
import io.github.ayfri.kore.bindings.Binding
import io.github.ayfri.kore.bindings.smithed.Smithed
import io.github.ayfri.kore.commands.Command
import io.github.ayfri.kore.commands.execute.execute
import io.github.ayfri.kore.features.tags.tag
import io.github.ayfri.kore.functions.function

object CustomBlock: Binding {
    override val namespace = "${Smithed.namespace}.custom_block"
    override val resourceId = ""

    fun main() = storage("place", namespace)

    context(DataPack)
    fun onPlace(namespace: String, vararg blockAndFunction: Pair<String, Command>) {
        function("on_place", namespace) {
            blockAndFunction.forEach { (block, function) ->
                execute {
                    ifCondition {
                        data(main(), "{blockAi:{id:\"$block\"}}")
                    }
                    run {
                        function
                    }
                }
            }
        }
        tag("event/on_place", "functions", namespace) {
            add("$namespace:on_place")
        }
    }
}
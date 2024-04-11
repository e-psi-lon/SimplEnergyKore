package io.github.ayfri.kore.bindings.smithed.actionbar

import io.github.ayfri.kore.DataPack
import io.github.ayfri.kore.arguments.types.resources.storage
import io.github.ayfri.kore.bindings.Binding
import io.github.ayfri.kore.bindings.smithed.Smithed
import io.github.ayfri.kore.commands.data
import io.github.ayfri.kore.commands.function
import io.github.ayfri.kore.features.tags.tag
import io.github.ayfri.kore.functions.Function
import io.github.ayfri.kore.functions.function
import kotlinx.serialization.encodeToString

object ActionBar: Binding {
    override val namespace = "${Smithed.namespace}.actionbar"
    override val resourceId = ""

    fun message() = storage("message", namespace)

    context(Function)
    private fun messageSend() = function("#$namespace", "message")

    context(Function)
    fun send(message: Message) {
        data(message()) {
            modify("input", snbt.encodeToString(message))
            messageSend()
        }

    }

    context(DataPack)
    fun onClickLockedContainer(namespace: String, onEvent: Function.() -> Unit) {
        function("generated_${onEvent.hashCode()}", namespace, "generated_scopes", onEvent)
        tag("event/player/on_click_locked_container", "function", "smithed.actionbar") {
            add("${namespace}:generated_scopes/generated_${onEvent.hashCode()}")
        }
    }
}
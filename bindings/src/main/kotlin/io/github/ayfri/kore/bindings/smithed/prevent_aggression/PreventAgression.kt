package io.github.ayfri.kore.bindings.smithed.prevent_aggression

import io.github.ayfri.kore.bindings.Binding
import io.github.ayfri.kore.bindings.smithed.Smithed

object PreventAgression: Binding {
    override val namespace = "${Smithed.namespace}.prevent_aggression"
    override val resourceId = ""

    fun preventAgression() = namespace


}
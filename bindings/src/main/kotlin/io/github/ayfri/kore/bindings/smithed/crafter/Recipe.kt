package io.github.ayfri.kore.bindings.smithed.crafter

import io.github.ayfri.kore.bindings.utils.CustomItemArgument
import io.github.ayfri.kore.functions.Function
import net.benwoodworth.knbt.StringifiedNbt


interface Recipe {
    val snbt: StringifiedNbt
        get() = StringifiedNbt { }
    var result: CustomItemArgument?
    context(Function)
    fun build()
}
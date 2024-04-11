package io.github.ayfri.kore.bindings.energy

import io.github.ayfri.kore.commands.function
import io.github.ayfri.kore.functions.Function


object Api {
    context(Function)
    fun initCable() = function("v1/api/init_cable", Energy.namespace)

    context(Function)
    fun initMachine() = function("v1/api/init_machine", Energy.namespace)

    context(Function)
    fun breakCable() = function("v1/api/break_cable", Energy.namespace)

    context(Function)
    fun breakMachine() = function("v1/api/break_machine", Energy.namespace)

    context(Function)
    fun modifyPlayerEnergy() = function("v1/api/modify_player_energy", Energy.namespace)
}
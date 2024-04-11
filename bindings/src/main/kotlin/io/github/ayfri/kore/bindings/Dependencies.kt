package io.github.ayfri.kore.bindings

import io.github.ayfri.kore.DataPack

class Dependencies(private val datapack: DataPack) {
    private val dependencies = mutableListOf<Binding>()

    fun addDependency(binding: Binding) {
        dependencies.add(binding)
    }

    fun generate() {
        datapack.generate()
    }

    fun generateZip() {
        datapack.generateZip()
    }
}

fun DataPack.dependencies(block: Dependencies.() -> Unit): Dependencies {
    val dependencies = Dependencies(this)
    dependencies.block()
    return dependencies
}
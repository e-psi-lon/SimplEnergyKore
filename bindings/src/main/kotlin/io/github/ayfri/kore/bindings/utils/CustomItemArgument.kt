package io.github.ayfri.kore.bindings.utils

import io.github.ayfri.kore.arguments.components.Components
import io.github.ayfri.kore.arguments.types.resources.ItemArgument
import io.github.ayfri.kore.arguments.types.resources.LootTableArgument

interface CustomItemArgument: ItemArgument {
    val baseItem: ItemArgument
    override var components: Components?
        get() = baseItem.components
        set(value) { baseItem.components = value }
    override val namespace: String
    override val name: String
    val lootTable: LootTableArgument

    override fun asId(): String {
        components = initializeComponents()
        return baseItem.asId()
    }

    override fun asString(): String {
        components = initializeComponents()
        return baseItem.asString()
    }

    override operator fun invoke(block: Components.() -> Unit): CustomItemArgument {
        return CustomItemArgument(name, namespace, lootTable, baseItem).apply {
            components = baseItem.components?.apply(block)
            components = initializeComponents()
        }
    }

    fun initializeComponents(): Components? {
        return baseItem.components
    }

    companion object {
        operator fun invoke(name: String, namespace: String, lootTableArgument: LootTableArgument, baseItem: ItemArgument): CustomItemArgument {
            return object : CustomItemArgument {
                override val baseItem = baseItem
                override val namespace = namespace
                override val name: String = name
                override val lootTable = lootTableArgument
            }.apply { components = initializeComponents() }
        }
    }
}
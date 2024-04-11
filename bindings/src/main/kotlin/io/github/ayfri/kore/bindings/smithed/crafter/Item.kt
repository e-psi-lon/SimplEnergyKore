package io.github.ayfri.kore.bindings.smithed.crafter

import io.github.ayfri.kore.arguments.components.Components
import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val count: Byte? = null,
    val id: String? = null,
    val tags: Components? = null,
    val slot: Byte? = null,
    val itemTags: List<String>? = null
) {
    fun addSlot(slot: Int) = Item(count, id, tags, slot.toByte(), itemTags)
}
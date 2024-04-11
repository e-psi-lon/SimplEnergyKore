package io.github.ayfri.kore.bindings.smithed.actionbar

import io.github.ayfri.kore.arguments.chatcomponents.ChatComponents
import kotlinx.serialization.Serializable


@Serializable
data class Message(
    val raw: String? = null,
    val json: ChatComponents? = null,
    val priority: MessagePriority? = null,
    val freeze: Int? = null,
)

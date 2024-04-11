package io.github.ayfri.kore.bindings.smithed.actionbar

import io.github.ayfri.kore.serializers.LowercaseSerializer
import kotlinx.serialization.Serializable

@Serializable(MessagePriority.Companion.MessagePrioritySerializer::class)
enum class MessagePriority {
    OVERRIDE,
    NOTIFICATION,
    CONDITIONAL,
    PERSISTENT;
    companion object {
        data object MessagePrioritySerializer: LowercaseSerializer<MessagePriority>(entries)
    }
}
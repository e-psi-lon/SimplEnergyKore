package io.github.ayfri.kore.bindings.energy

import io.github.ayfri.kore.bindings.utils.SelectorTag
import io.github.ayfri.kore.arguments.numbers.ranges.IntRangeOrInt
import io.github.ayfri.kore.arguments.scores.Scores
import io.github.ayfri.kore.arguments.scores.SelectorScore
import io.github.ayfri.kore.arguments.scores.score
import io.github.ayfri.kore.arguments.types.literals.SelectorArgument
import io.github.ayfri.kore.bindings.Binding
import io.github.ayfri.kore.bindings.utils.SelectorTags
import io.github.ayfri.kore.commands.function
import io.github.ayfri.kore.functions.Function
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

object Energy: Binding {
    override val namespace: String = "energy"
    override val resourceId: String = ""

    val api = Api

    fun send(selector: SelectorArgument, reverse: Boolean = false): SelectorArgument {
        selector.selector.nbtData.apply {
            tag = (tag?.let { SelectorTags.parse(it) }?.plus(SelectorTag("$namespace.send", reverse)))?.asString()
        }
        return selector
    }

    fun sender(selector: SelectorArgument): SelectorArgument {
        selector.selector.nbtData.apply {
            tag = (tag?.let { SelectorTags.parse(it) }?.plus(
                SelectorTag("$namespace.send") + SelectorTag("$namespace.receive", true)
            )
            )?.asString()
        }
        return selector
    }

    fun receive(selector: SelectorArgument, reverse: Boolean = false): SelectorArgument {
        selector.selector.nbtData.apply {
            tag = (tag?.let { SelectorTags.parse(it) }?.plus(SelectorTag("$namespace.receive", reverse)))?.asString()
        }
        return selector
    }

    fun receiver(selector: SelectorArgument): SelectorArgument {
        selector.selector.nbtData.apply {
            tag = (tag?.let { SelectorTags.parse(it) }?.plus(
                SelectorTag("$namespace.send", true) + SelectorTag("$namespace.receive")
            )
                    )?.asString()
        }
        return selector
    }

    fun cable(selector: SelectorArgument, reverse: Boolean = false): SelectorArgument {
        selector.selector.nbtData.apply {
            tag = (tag?.let { SelectorTags.parse(it) }?.plus(SelectorTag("$namespace.cable", reverse)))?.asString()
        }
        return selector
    }

    fun senderAndReceiver(selector: SelectorArgument): SelectorArgument {
        selector.selector.nbtData.apply {
            tag = (tag?.let { SelectorTags.parse(it) }?.plus(
                SelectorTag("$namespace.send") + SelectorTag("$namespace.receive")
            )
                    )?.asString()
        }
        return selector
    }

    context(Function)
    fun cableCanConnect() = function("v1/cable_can_connect", "#$namespace")

    context(Function)
    fun cableUpdate() = function("v1/cable_update", "#$namespace")

    context(Function)
    fun energyUpdate() = function("v1/energy_update", "#$namespace")

    context(Function)
    fun updateEnergyItem() = function("v1/update_energy_item", "#$namespace")

    @Serializable
    @SerialName("energy")
    data class EnergyData(val storage: Int, val maxStorage: Int)

    context(Scores<SelectorScore>)
    fun data() = score("$namespace.data")

    context(Scores<SelectorScore>)
    fun data(value: Int) = score("$namespace.data", value)

    context(Scores<SelectorScore>)
    fun data(value: IntRange) = score("$namespace.data", value)

    context(Scores<SelectorScore>)
    fun data(value: IntRangeOrInt) = score("$namespace.data", value)

    context(Scores<SelectorScore>)
    fun storage() = score("$namespace.storage")

    context(Scores<SelectorScore>)
    fun storage(value: Int) = score("$namespace.storage", value)

    context(Scores<SelectorScore>)
    fun storage(value: IntRange) = score("$namespace.storage", value)

    context(Scores<SelectorScore>)
    fun storage(value: IntRangeOrInt) = score("$namespace.storage", value)

    context(Scores<SelectorScore>)
    fun maxStorage() = score("$namespace.max_storage")

    context(Scores<SelectorScore>)
    fun maxStorage(value: Int) = score("$namespace.max_storage", value)

    context(Scores<SelectorScore>)
    fun maxStorage(value: IntRange) = score("$namespace.max_storage", value)

    context(Scores<SelectorScore>)
    fun maxStorage(value: IntRangeOrInt) = score("$namespace.max_storage", value)

    context(Scores<SelectorScore>)
    fun transferRate() = score("$namespace.transfer_rate")

    context(Scores<SelectorScore>)
    fun transferRate(value: Int) = score("$namespace.transfer_rate", value)

    context(Scores<SelectorScore>)
    fun transferRate(value: IntRange) = score("$namespace.transfer_rate", value)

    context(Scores<SelectorScore>)
    fun transferRate(value: IntRangeOrInt) = score("$namespace.transfer_rate", value)

    context(Scores<SelectorScore>)
    fun changeRate() = score("$namespace.change_rate")

    context(Scores<SelectorScore>)
    fun changeRate(value: Int) = score("$namespace.change_rate", value)

    context(Scores<SelectorScore>)
    fun changeRate(value: IntRange) = score("$namespace.change_rate", value)

    context(Scores<SelectorScore>)
    fun changeRate(value: IntRangeOrInt) = score("$namespace.change_rate", value)
}
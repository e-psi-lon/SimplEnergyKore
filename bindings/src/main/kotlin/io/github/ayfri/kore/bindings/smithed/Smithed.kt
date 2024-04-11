package io.github.ayfri.kore.bindings.smithed

import io.github.ayfri.kore.arguments.scores.Scores
import io.github.ayfri.kore.arguments.scores.SelectorScore
import io.github.ayfri.kore.arguments.scores.score
import io.github.ayfri.kore.arguments.types.ScoreHolderArgument
import io.github.ayfri.kore.arguments.types.literals.tag
import io.github.ayfri.kore.commands.execute.ExecuteCondition
import io.github.ayfri.kore.commands.execute.ExecuteStore
import io.github.ayfri.kore.bindings.smithed.crafter.Crafter
import io.github.ayfri.kore.bindings.smithed.actionbar.ActionBar
import io.github.ayfri.kore.bindings.smithed.custom_block.CustomBlock
import io.github.ayfri.kore.bindings.smithed.prevent_aggression.PreventAgression


object Smithed {
    val namespace: String = "smithed"

    val crafter = Crafter
    val actionBar = ActionBar
    val customBlock = CustomBlock
    val preventAggression = PreventAgression

    fun entity() = tag("${namespace}.entity")

    context(Scores<SelectorScore>)
    fun data() = score("${namespace}.data")

    fun data() = "${namespace}.data"

    context(ExecuteStore)
    fun data(target: ScoreHolderArgument) = score(target, "${namespace}.data")

    context(ExecuteCondition)
    fun data(target: ScoreHolderArgument) = score(target, "${namespace}.data")
}


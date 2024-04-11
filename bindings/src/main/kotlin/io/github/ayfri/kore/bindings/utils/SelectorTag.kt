package io.github.ayfri.kore.bindings.utils

class SelectorTag(val tag: String, val not: Boolean = false) {
    fun asString(): String {
        return if (not) "!$tag" else tag
    }

    operator fun not(): SelectorTag {
        return SelectorTag(tag, !not)
    }

    operator fun plus(tag: SelectorTag): SelectorTags {
        return SelectorTags(listOf(this, tag))
    }

    operator fun plus(tags: SelectorTags): SelectorTags {
        return SelectorTags(listOf(this) + tags.tags)
    }
}

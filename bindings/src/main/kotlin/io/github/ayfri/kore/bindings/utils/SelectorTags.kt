package io.github.ayfri.kore.bindings.utils

class SelectorTags(val tags: List<SelectorTag>) {
    fun asString(): String {
        return tags.joinToString(", tag=") { it.asString() }
    }

    operator fun plus(tag: SelectorTag): SelectorTags {
        return SelectorTags(tags + listOf(tag))
    }

    operator fun plus(tags: SelectorTags): SelectorTags {
        return SelectorTags(this.tags + tags.tags)
    }

    operator fun not(): SelectorTags {
        return SelectorTags(tags.map { !it })
    }

    companion object {
        fun parse(string: String): SelectorTags {
            val tags = string.split(", ").map {
                val split = it.split("=")
                return@map if (split.size == 2) {
                    if (split[1].startsWith("!")) {
                        SelectorTag(split[1].removePrefix("!"), true)
                    } else {
                        SelectorTag(split[1])
                    }
                } else {
                    if (split[0].startsWith("!")) {
                        SelectorTag(split[0].removePrefix("!"), true)
                    } else {
                        SelectorTag(split[0])
                    }
                }
            }
            return SelectorTags(tags)
        }
    }
}
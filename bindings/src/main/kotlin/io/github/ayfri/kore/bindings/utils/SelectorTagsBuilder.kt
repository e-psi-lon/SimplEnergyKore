package io.github.ayfri.kore.bindings.utils

class SelectorTagsBuilder {
    private val tags = mutableListOf<SelectorTag>()
    operator fun String.unaryPlus() {
        if (this.startsWith("!")) {
            tags.add(SelectorTag(this.removePrefix("!"), true))
        } else {
            tags.add(SelectorTag(this))
        }
    }
    operator fun String.unaryMinus() {
        if (this.startsWith("!")) {
            tags.add(SelectorTag(this.removePrefix("!")))
        } else {
            tags.add(SelectorTag(this, true))
        }
    }
    operator fun SelectorTag.unaryMinus() {
        tags.add(!this)
    }
    operator fun SelectorTag.unaryPlus() {
        tags.add(this)
    }

    fun build(): SelectorTags = SelectorTags(tags)
}

fun buildTags(tag: String? = null, builder: SelectorTagsBuilder.() -> Unit = {}): String {
    val selector = SelectorTagsBuilder().apply(builder)
    val previousTags = tag?.let { SelectorTags.parse(it) }
    if (previousTags != null) {
        return (previousTags + selector.build()).asString()
    }
    return selector.build().asString()
}
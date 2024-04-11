package io.github.ayfri.kore.bindings

import io.github.ayfri.kore.DataPack
import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipInputStream
import net.benwoodworth.knbt.StringifiedNbt


interface Binding {
    val namespace: String
    val resourceId: String
    val resource: ZipInputStream
        get() {
            val resourceUrl = this::class.java.classLoader.getResource(resourceId)
            val stream = resourceUrl?.openStream() ?: throw IllegalArgumentException("Resource $resourceId not found.")
            return ZipInputStream(stream)
        }
    val snbt: StringifiedNbt
        get() = StringifiedNbt { }
}

var bindings: List<Binding> = listOf()

fun DataPack.registerBinding(binding: Binding) {
    bindings += binding
}

fun DataPack.generateBindings() {
    for (binding in bindings) {
        binding.resource.use { zip ->
            var entry = zip.nextEntry
            while (entry != null) {
                if (entry.name.startsWith("data/")) {
                    val outputFile = File("$path/$name/${entry.name}")
                    if (entry.isDirectory) {
                        outputFile.mkdirs()
                    } else {
                        outputFile.parentFile.mkdirs()
                        FileOutputStream(outputFile).use { fos ->
                            zip.copyTo(fos)
                        }
                    }
                }
                entry = zip.nextEntry
            }
        }
    }
}

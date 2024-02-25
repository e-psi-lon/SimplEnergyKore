plugins {
    kotlin("jvm") version "1.9.22"
    application
}

group = "fr.e_psi_lon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.ayfri.kore:kore:1.2.0-24w07a")
}


kotlin {
    jvmToolchain(17)
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-receivers")
    }
}

application {
    mainClass.set("MainKt")
}
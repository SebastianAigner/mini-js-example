    plugins {
    id("org.jetbrains.kotlin.js") version "1.3.70-eap-42"
        id("org.jetbrains.kotlin.plugin.serialization") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))

    //ktor stuff
    val ktor_version = "1.2.6"
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-js:$ktor_version")

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.3")

    //serialization stuff
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:0.13.0")

    // kotlinx.html
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.6.10")

    //currently required dependencies for using ktor on JS
    implementation(npm("text-encoding")) //required for ktor-client-js
    implementation(npm("abort-controller")) //required for ktor-client-core
    implementation(npm("tls")) //required for ktor-client-
    implementation(npm("utf-8-validate")) //required for ktor-client-
    implementation(npm("fs"))
    implementation(npm("bufferutil"))
}

kotlin.target.browser { }
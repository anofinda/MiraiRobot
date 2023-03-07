plugins {
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.10"
    java
    application

}

group = "com.anofinda"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("com.charleskorn.kaml:kaml:${properties["kaml.version"]}")
    api("net.mamoe:mirai-core:${properties["mirai.version"]}")
    implementation("org.slf4j:slf4j-simple:${properties["slf4j.simple.version"]}")
    implementation("org.apache.logging.log4j:log4j-core:${properties["log4j.version"]}")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}
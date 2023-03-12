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
    flatDir { dirs("lib") }
}

dependencies {
    testImplementation(kotlin("test"))
    //kotlin 协程
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    //kaml yaml解析
    implementation("com.charleskorn.kaml:kaml:${properties["kaml.version"]}")
    //mirai QQ机器人
    api("net.mamoe:mirai-core-all:${properties["mirai.version"]}")
    //slf4j log4j 日志
    implementation("org.slf4j:slf4j-simple:${properties["slf4j.simple.version"]}")
    implementation("org.apache.logging.log4j:log4j-core:${properties["log4j.version"]}")
    //koin依赖注入
    implementation("io.insert-koin:koin-core:${properties["koin.version"]}")
    //mirai 登录临时修复插件
    implementation(files("lib/fix-protocol-version-1.1.0.mirai2.jar"))
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
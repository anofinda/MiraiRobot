package com.anofinda.miraibot

import com.anofinda.miraibot.configuration.AccountConfiguration
import com.charleskorn.kaml.Yaml
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.utils.BotConfiguration
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val stream = Files.newInputStream(Paths.get("build/resources/main/com.anofinda.miraibot/account.yml"))
    val accountConfiguration = Yaml.default.decodeFromStream(AccountConfiguration.serializer(), stream)
    val botConfiguration = BotConfiguration()
//    botConfiguration.protocol = BotConfiguration.MiraiProtocol.MACOS
    botConfiguration.cacheDir = File("cache")
    botConfiguration.fileBasedDeviceInfo()
    val bot = BotFactory.newBot(accountConfiguration.account, accountConfiguration.password, botConfiguration)
    runBlocking {
        launch {
            bot.login()
        }
    }
}
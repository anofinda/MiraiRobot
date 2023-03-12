package com.anofinda.miraibot.modules

import com.anofinda.miraibot.configuration.AccountConfiguration
import com.anofinda.miraibot.configuration.GroupConfiguration
import com.charleskorn.kaml.Yaml
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import net.mamoe.mirai.utils.BotConfiguration
import org.koin.dsl.module
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

val robotModule = module {
    single<AccountConfiguration> {
        val reader = Files
            .newInputStream(Paths.get("build/resources/main/com.anofinda.miraibot/account.json"))
            .bufferedReader()
        val accountConfiguration: AccountConfiguration
        reader.use {
            accountConfiguration = Json.decodeFromString(reader.readText())
        }
        accountConfiguration
    }
    single<BotConfiguration> {
        val botConfiguration = BotConfiguration()
        botConfiguration.protocol = BotConfiguration.MiraiProtocol.MACOS
        botConfiguration.fileBasedDeviceInfo()
        botConfiguration.enableContactCache()
        botConfiguration
    }

    single<GroupConfiguration> {
        val reader = Files
            .newInputStream(Paths.get("build/resources/main/com.anofinda.miraibot/group.json"))
            .bufferedReader()
        val groupConfiguration: GroupConfiguration
        reader.use {
            groupConfiguration = Json.decodeFromString(reader.readText())
        }
        groupConfiguration
    }
}
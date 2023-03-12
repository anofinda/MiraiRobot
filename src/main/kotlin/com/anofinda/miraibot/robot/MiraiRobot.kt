package com.anofinda.miraibot.robot

import com.anofinda.miraibot.configuration.AccountConfiguration
import com.anofinda.miraibot.configuration.GroupConfiguration
import kotlinx.coroutines.runBlocking
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.events.MessageRecallEvent
import net.mamoe.mirai.message.data.MessageSource
import net.mamoe.mirai.message.data.toPlainText
import net.mamoe.mirai.utils.BotConfiguration
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class MiraiRobot : KoinComponent {
    private val account: AccountConfiguration by inject()
    private val botConfiguration: BotConfiguration by inject()
    private val groups: GroupConfiguration by inject()
    fun start() = runBlocking {
        val bot = BotFactory.newBot(account.id, account.password, botConfiguration)
        bot.login()
        val eventChanel = bot.eventChannel
        eventChanel.subscribeAlways<GroupMessageEvent> {
            if (group.id == groups.dormitory) group.sendMessage("from@anofinda:".toPlainText() + message)
        }
        eventChanel.subscribeAlways<MessageRecallEvent.GroupRecall> {
            if (group.id == groups.dormitory) group.sendMessage("群中${author}刚刚撤回一条信息")
        }
    }
}
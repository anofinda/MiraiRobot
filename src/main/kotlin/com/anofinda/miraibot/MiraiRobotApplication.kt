package com.anofinda.miraibot

import com.anofinda.miraibot.modules.robotModule
import com.anofinda.miraibot.robot.MiraiRobot
import org.koin.core.context.startKoin
import xyz.cssxsh.mirai.tool.FixProtocolVersion
/**
 * @author dongyudeng
 */

fun main() {
    startKoin {
        modules(robotModule)
    }
    FixProtocolVersion.update()
    val robot = MiraiRobot()
    robot.start()
}
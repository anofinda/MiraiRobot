package com.anofinda.miraibot.configuration

import kotlinx.serialization.Serializable

@Serializable
data class AccountConfiguration(val id:Long, val password:String)

package com.anofinda.miraibot.configuration

import kotlinx.serialization.Serializable

@Serializable
data class AccountConfiguration(val account:Long, val password:String)

package com.capstone.server.common.exceptions

import java.lang.RuntimeException

data class BadRequestException (override val message:String): RuntimeException(message)
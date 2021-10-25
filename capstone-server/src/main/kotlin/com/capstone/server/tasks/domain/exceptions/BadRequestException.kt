package com.capstone.server.tasks.domain.exceptions

import java.lang.RuntimeException

data class BadRequestException(override val message: String): RuntimeException(message) {
}
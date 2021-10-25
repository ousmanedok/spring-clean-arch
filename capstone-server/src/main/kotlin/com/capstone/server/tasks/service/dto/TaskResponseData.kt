package com.capstone.server.tasks.service.dto

import com.capstone.server.tasks.domain.models.Task

data class TaskResponseData(val name: String, val description: String, val active: Boolean)
fun Task.toTaskResponseData() =
    TaskResponseData(
        name = this.name,
        description = this.description,
        active = this.active
    )
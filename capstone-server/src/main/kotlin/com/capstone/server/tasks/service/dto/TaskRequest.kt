package com.capstone.server.tasks.service.dto

sealed class TaskRequest {
    data class AddTaskRequest(val name: String, val description: String) : TaskRequest()
    data class UpdateRequest(val name: String, val description: String, val active: Boolean) : TaskRequest()
    data class DeleteRequest(val name: String) : TaskRequest()
    data class TaskListRequest(val active: Boolean? = null) : TaskRequest()
}
package com.capstone.server.tasks.service.dto

sealed class TaskResponse {
    data class TaskItemResponse(val data: TaskResponseData): TaskResponse()
    data class TaskListResponse(val data: List<TaskResponseData>): TaskResponse()
    object TaskDeleteResponse : TaskResponse()
    data class InvalidResponse(val exception: Exception) : TaskResponse()
}
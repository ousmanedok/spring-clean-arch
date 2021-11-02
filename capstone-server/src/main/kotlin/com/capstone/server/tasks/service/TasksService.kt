package com.capstone.server.tasks.service.dto

import com.capstone.server.tasks.domain.usecases.AddTaskUseCase
import com.capstone.server.tasks.domain.usecases.DeleteTaskUseCase
import com.capstone.server.tasks.domain.usecases.GetAllTasksUseCase
import com.capstone.server.tasks.domain.usecases.UpdateTaskUseCase
import org.springframework.stereotype.Service

interface TasksService {
    fun addTask(request: TaskRequest.AddTaskRequest): TaskResponse
    fun getAllTasks(request: TaskRequest.TaskListRequest): TaskResponse
    fun updateTask(request: TaskRequest.UpdateRequest): TaskResponse
    fun deleteTask(request: TaskRequest.DeleteRequest): TaskResponse
}

@Service("tasksService")
internal class TasksServiceImpl(
    val addTaskUseCase: AddTaskUseCase,
    val getAllTasksUseCase: GetAllTasksUseCase,
    val updateTaskUseCase: UpdateTaskUseCase,
    val deleteTaskUseCase: DeleteTaskUseCase
) : TasksService {
    override fun addTask(request: TaskRequest.AddTaskRequest): TaskResponse {
        return when (val response = addTaskUseCase.invoke(request)) {
            is TaskResponse.InvalidResponse -> throw response.exception
            else -> response
        }
    }

    override fun getAllTasks(request: TaskRequest.TaskListRequest): TaskResponse {
        return getAllTasksUseCase(request)
    }

    override fun updateTask(request: TaskRequest.UpdateRequest): TaskResponse {
        return when (val response = updateTaskUseCase(request)) {
            is TaskResponse.InvalidResponse -> throw response.exception
            else -> response
        }
    }

    override fun deleteTask(request: TaskRequest.DeleteRequest): TaskResponse {
        return when (val response = deleteTaskUseCase(request)) {
            is TaskResponse.InvalidResponse -> throw response.exception
            else -> response
        }
    }
}
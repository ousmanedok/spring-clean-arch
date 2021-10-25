package com.capstone.server.tasks.domain.usecases

import com.capstone.server.tasks.data.TaskEntity
import com.capstone.server.tasks.data.TasksDataRepository
import com.capstone.server.tasks.data.toTask
import com.capstone.server.tasks.service.dto.TaskRequest.TaskListRequest
import com.capstone.server.tasks.service.dto.TaskResponse
import com.capstone.server.tasks.service.dto.toTaskResponseData
import org.springframework.stereotype.Component

interface GetAllTasksUseCase {
    operator fun invoke(request: TaskListRequest): TaskResponse
}

@Component("getAllTasksUseCase")
internal class GetAllTasksUseCaseImpl(val tasksDataRepository: TasksDataRepository) : GetAllTasksUseCase {
    override fun invoke(request: TaskListRequest): TaskResponse {
        val result: List<TaskEntity> = if (request.active == null) {
            // retrieve all items in list.
            tasksDataRepository.findAll()
        } else {
            // retrieve all items based on active state.
            tasksDataRepository.findAllByActive(request.active)
        }
        return TaskResponse.TaskListResponse(
            data = result.map { taskEntity ->
                taskEntity.toTask().toTaskResponseData()
            })
    }
}
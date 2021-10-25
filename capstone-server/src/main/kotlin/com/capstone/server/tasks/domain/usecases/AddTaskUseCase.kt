package com.capstone.server.tasks.domain.usecases

import com.capstone.server.tasks.data.TaskEntity
import com.capstone.server.tasks.data.TasksDataRepository
import com.capstone.server.tasks.data.toTask
import com.capstone.server.tasks.domain.exceptions.BadRequestException
import com.capstone.server.tasks.service.dto.TaskRequest.AddTaskRequest
import com.capstone.server.tasks.service.dto.TaskResponse
import com.capstone.server.tasks.service.dto.toTaskResponseData
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

interface AddTaskUseCase {
    operator fun invoke(request: AddTaskRequest): TaskResponse
}

@Component("addTaskUseCase")
internal class AddTaskUseCaseImpl(val tasksDataRepository: TasksDataRepository) : AddTaskUseCase {
    private val log = LoggerFactory.getLogger(AddTaskUseCaseImpl::class.java)
    override fun invoke(request: AddTaskRequest): TaskResponse {
        return if (tasksDataRepository.existsByName(request.name)) {
            TaskResponse.InvalidResponse(BadRequestException("This task ${request.name} already exists"))
        } else {
            val task = tasksDataRepository.save(
                TaskEntity(
                    name = request.name, description =
                    request.description,
                    active = true
                )
            ).toTask()
            log.debug("task added:${task}")
            return TaskResponse.TaskItemResponse(
                data = task.toTaskResponseData()
            )
        }
    }
}
package com.capstone.server.tasks.domain.usecases

import com.capstone.server.tasks.data.TasksDataRepository
import com.capstone.server.tasks.data.toTask
import com.capstone.server.tasks.domain.exceptions.BadRequestException
import com.capstone.server.tasks.service.dto.TaskRequest.UpdateRequest
import com.capstone.server.tasks.service.dto.TaskResponse
import com.capstone.server.tasks.service.dto.toTaskResponseData
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.time.LocalDateTime

interface UpdateTaskUseCase {
    operator fun invoke(request: UpdateRequest): TaskResponse
}

@Component("updateTaskUseCase")
internal class UpdateTaskUseCaseImpl(val tasksDataRepository: TasksDataRepository) : UpdateTaskUseCase {
    private val log = LoggerFactory.getLogger(UpdateTaskUseCaseImpl::class.java)
    override fun invoke(request: UpdateRequest): TaskResponse {
        when {
            request.name.isBlank() -> {
                return TaskResponse.InvalidResponse(BadRequestException("Task name cannot be blank"))
            }
            request.description.isBlank() -> {
                return TaskResponse.InvalidResponse(BadRequestException("Task description cannot be blank"))
            }
            else -> {
                val taskEntity = tasksDataRepository.findByName(request.name)
                return if (taskEntity == null) {
                    TaskResponse.InvalidResponse(BadRequestException("Task with name = {${request.name}} does not exist"))
                } else {
                    log.debug("updating task entity $taskEntity")
                    val updateEntity = taskEntity.copy(description = request.description, active = request.active)
                    updateEntity.updatedOn = LocalDateTime.now()
                    log.debug("updated values ... $updateEntity")
                    val result = tasksDataRepository.save(updateEntity)
                    log.debug("updated entity = $result")
                    TaskResponse.TaskItemResponse(data = result.toTask().toTaskResponseData())
                }
            }
        }
    }
}

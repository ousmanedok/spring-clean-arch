package com.capstone.server.tasks.domain.usecases

import com.capstone.server.tasks.data.TasksDataRepository
import com.capstone.server.tasks.domain.exceptions.BadRequestException
import com.capstone.server.tasks.service.dto.TaskRequest.DeleteRequest
import com.capstone.server.tasks.service.dto.TaskResponse
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

interface DeleteTaskUseCase {
    operator fun invoke(request: DeleteRequest): TaskResponse
}

@Component("deleteTaskUseCase")
internal class DeleteTaskUseCaseImpl(val tasksDataRepository: TasksDataRepository) : DeleteTaskUseCase {
    private val log = LoggerFactory.getLogger(DeleteTaskUseCaseImpl::class.java)
    override fun invoke(request: DeleteRequest): TaskResponse {
        return when {
            request.name.isBlank() -> {
                TaskResponse.InvalidResponse(BadRequestException("Task name cannot be blank"))
            }
            else -> {
                val entity = tasksDataRepository.findByName(request.name)
                if (entity == null) {
                    TaskResponse.InvalidResponse(BadRequestException("Task name{${request.name}} does not exists"))
                } else {
                    log.debug("deleting $entity")
                    tasksDataRepository.delete(entity)
                    TaskResponse.TaskDeleteResponse
                }
            }
        }
    }
}
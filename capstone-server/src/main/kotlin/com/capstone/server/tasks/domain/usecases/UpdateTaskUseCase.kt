package com.capstone.server.tasks.domain.usecases

import com.capstone.server.tasks.data.TasksDataRepository
import com.capstone.server.tasks.service.dto.TaskRequest.UpdateRequest
import com.capstone.server.tasks.service.dto.TaskResponse
import org.springframework.stereotype.Component

interface UpdateTaskUseCase {
    operator fun invoke(request: UpdateRequest): TaskResponse
}

@Component("updateTaskUseCase")
internal class UpdateTaskUseCaseImpl(val tasksDataRepository: TasksDataRepository) : UpdateTaskUseCase {
    override fun invoke(request: UpdateRequest): TaskResponse {
        TODO("Not yet implemented")
    }
}

package com.capstone.server.tasks.domain.usecases

import com.capstone.server.tasks.data.TasksDataRepository
import com.capstone.server.tasks.service.dto.TaskRequest.DeleteRequest
import com.capstone.server.tasks.service.dto.TaskResponse
import org.springframework.stereotype.Component

interface DeleteTaskUseCase {
    operator fun invoke(request: DeleteRequest): TaskResponse
}

@Component("deleteTaskUseCase")
internal class DeleteTaskUseCaseImpl(val tasksDataRepository: TasksDataRepository): DeleteTaskUseCase {
    override fun invoke(request: DeleteRequest): TaskResponse {
        TODO("Not yet implemented")
    }
}
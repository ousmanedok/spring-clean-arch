package com.capstone.server.tasks.data

import com.capstone.server.tasks.domain.models.Task
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

/**
 * TaskEntity. this is the entity that is stored in mongodb.
 */
@Document(collection = "tasks")
data class TaskEntity(
    @Id
    var id: ObjectId? = null,
    internal val name: String,
    internal val description: String,
    internal val active: Boolean
) {
    internal var createdOn: LocalDateTime? = LocalDateTime.now()
    internal var updatedOn: LocalDateTime? = LocalDateTime.now()
}

fun Task.toTaskEntity() =
    TaskEntity(
        name = this.name,
        description = this.description,
        active = this.active
    )

fun TaskEntity.toTask() =
    Task(
        name = this.name,
        description = this.description,
        active = this.active
    )
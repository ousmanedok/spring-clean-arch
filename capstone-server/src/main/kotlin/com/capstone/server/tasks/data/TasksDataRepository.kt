package com.capstone.server.tasks.data

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * This is the repository that help us talk to the mongodb database.
 */
@Repository
interface TasksDataRepository : MongoRepository<TaskEntity, ObjectId> {
    fun findByName(name: String): TaskEntity?
    fun existsByName(taskName: String): Boolean
    fun findAllByActive(active: Boolean): List<TaskEntity>
    /**
     * This function below is the same as the function [findAllByActive] with active=true
     */
    fun findAllByActiveIsTrue(): List<TaskEntity>

    /**
     * This function below is the same as the function [findAllByActive] with active=false
     */
    fun findAllByActiveIsFalse(): List<TaskEntity>
}
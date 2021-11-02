package com.capstone.server.controllers

import com.capstone.server.tasks.service.dto.TaskRequest
import com.capstone.server.tasks.service.dto.TaskResponse
import com.capstone.server.tasks.service.dto.TasksService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Pour tester l'application sure ta machine tu peux simplement utilizer le lien:
 * http://localhost:8080/api/tasks/list pour voir toutes les taches actuellement presentes dans la base de donner.
 */
@RestController
@RequestMapping("/api/tasks")
class TasksController(
    val tasksService: TasksService
) {
    private val log = LoggerFactory.getLogger(TasksController::class.java)

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun addTask(@Valid @RequestBody request: TaskRequest.AddTaskRequest): TaskResponse {
        log.debug("adding a new place {$request}")
        return tasksService.addTask(request)
    }

    /**
     *  Retrieves all tasks.
     *  You can filter the tasks you want to retrieve by passing in the active flag to the url.
     *  Example: http://localhost:8080/api/tasks/list?active=true will return all active tasks.
     *  http://localhost:8080/api/tasks/list?active=false will return all completed tasks.
     *  Default return all tasks both active and completed.
     */
    @GetMapping("/list")
    fun getAllTasks(@RequestParam(required = false) active: Boolean? = null): TaskResponse {
        val request = TaskRequest.TaskListRequest((active))
        log.debug("fetching all tasks for {$request}")
        return tasksService.getAllTasks(request)
    }

    /**
     * Updates a task description and active.
     * To update the task you can pass the update request json body to the endpoint.
     * Endpoint: http://localhost:8080/api/tasks/update
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    fun updateTask(@Valid @RequestBody request: TaskRequest.UpdateRequest): TaskResponse {
        log.debug("update task = {$request}")
        return tasksService.updateTask(request)
    }

    /**
     * Deletes a task.
     * Use endpoint: http://localhost:8080/api/tasks/name for localhost test.
     * pass in the name of the task to be deleted.
     */
    @DeleteMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    fun deleteTask(@Valid @RequestBody request: TaskRequest.DeleteRequest): TaskResponse {
        log.debug("delete task = {$request}")
        return tasksService.deleteTask(request)
    }
}
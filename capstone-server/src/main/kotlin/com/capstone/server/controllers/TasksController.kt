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

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    fun updateTask(@Valid @RequestBody request: TaskRequest.UpdateRequest): TaskResponse {
        /**
         * Cette function est pour le edit d'une tache. Le Nom de la tache ne change pas, mais seulement utiliser pour
         * obtenir l'object qui est deja dans la base de donner.
         * Ce servir de l'exemple de addTask pour implementer cette funtion.
         */
        TODO()
    }

    @DeleteMapping("name")
    @ResponseStatus(HttpStatus.OK)
    fun deleteTask(@Valid @RequestBody request: TaskRequest.DeleteRequest): TaskResponse {
        /**
         * Cette function est pour le delete d'une tache. Le Nom de la tache ne change pas, mais seulement utiliser pour
         * obtenir l'object qui est deja dans la base de donner.
         * Ce servir de l'exemple de addTask pour implementer cette function.
         * Un point cle ici est de ce rendre compte de la method de la function @DeleteMapping
         */
        TODO()
    }
}
package com.capstone.server.controllers

import com.capstone.server.content.service.ArticlesService
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
import com.capstone.server.tasks.service.dto.TaskRequest
import com.capstone.server.tasks.service.dto.TaskResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/articles")
class ArticlesController(
        val articlesService : ArticlesService
) {
    private val log = LoggerFactory.getLogger(ArticlesController::class.java)

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun addArticle(@Valid @RequestBody request: ArticleRequest.AddArticleRequest): ArticleResponse {
        log.debug("adding a new article {$request}")
        return articlesService.addArticle(request)
    }

    @GetMapping("/list")
    fun getArticles(@RequestParam(required = false) limit: Int): ArticleResponse{
        val request = ArticleRequest.GetAllArticlesRequest((limit))
        log.debug("Fetching articles for {$request}")
        return articlesService.getAllArticles(request)
    }

    //Endpoint pour supprimer un article par titre: http://localhost:8080/api/tasks/title

    @DeleteMapping("/title")
    @ResponseStatus(HttpStatus.OK)
    fun deleteArticle(@Valid @RequestBody request: ArticleRequest.DeleteArticleRequestByTitle): ArticleResponse {
        log.debug("delete article = {$request}")
        return articlesService.deleteArticle(request)
    }
}
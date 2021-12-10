package com.capstone.server.controllers

import com.capstone.server.content.service.ArticlesService
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
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
}
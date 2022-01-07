package com.capstone.server.controllers

import com.capstone.server.content.service.ArticlesService
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Pour tester l'application sur ta machine tu peux simplement utiliser ce lien:
 * http://localhost:8080/api/articles/list pour voir toutes les articles actuellement presentes dans la base de donneés.
 */

@RestController
@RequestMapping("/api/articles")
class ArticlesController(
        val articlesService : ArticlesService
) {
    private val log = LoggerFactory.getLogger(ArticlesController::class.java)

     //Endpoint pour ajouter un article: http://localhost:8080/api/articles/add

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    fun addArticle(@Valid @RequestBody request: ArticleRequest.AddArticleRequest): ArticleResponse {
        log.debug("adding a new article {$request}")
        return articlesService.addArticle(request)
    }

    //Endpoint pour la liste des articles: http://localhost:8080/api/articles/list

    @GetMapping("/list")
    fun getArticles(@RequestParam(required = false) limit: Int? ): ArticleResponse{
        val request =  ArticleRequest.GetAllArticlesRequest((limit))
        log.debug("Fetching articles for {$request}")
        return articlesService.getAllArticles(request)
    }


    //Endpoint pour mettre à jour un article: http://localhost:8080/api/articles/update

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    fun updateArticle(@Valid @RequestBody request: ArticleRequest.UpdateArticleRequest): ArticleResponse {
        log.debug("update article = {$request}")
        return articlesService.updateArticle(request)
    }

    //Endpoint pour supprimer un article par titre: http://localhost:8080/api/articles/title

    @DeleteMapping("/title")
    @ResponseStatus(HttpStatus.OK)
    fun deleteArticle(@Valid @RequestBody request: ArticleRequest.DeleteArticleRequestByTitle): ArticleResponse {
        log.debug("delete article = {$request}")
        return articlesService.deleteArticle(request)
    }
}
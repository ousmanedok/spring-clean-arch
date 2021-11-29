package com.capstone.server.content.service

import com.capstone.server.content.domain.AddArticleUseCase
import com.capstone.server.content.domain.DeleteArticleUseCase
import com.capstone.server.content.domain.GetAllArticlesUseCase
import com.capstone.server.content.domain.UpdateArticleUseCase
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
import org.springframework.stereotype.Service

interface ArticlesService {
    fun addArticle(request: ArticleRequest.AddArticleRequest): ArticleResponse
    fun getAllArticles(request: ArticleRequest.GetAllArticlesRequest): ArticleResponse
    fun updateArticle(request: ArticleRequest.UpdateArticleRequest): ArticleResponse
    fun deleteArticle(request: ArticleRequest.DeleteArticleRequestByTitle): ArticleResponse
}

@Service("articlesService")
internal class ArticlesServiceImpl(
    val addArticleUseCase: AddArticleUseCase,
    val getAllArticlesUseCase: GetAllArticlesUseCase,
    val updateArticleUseCase: UpdateArticleUseCase,
    val deleteArticleUseCase: DeleteArticleUseCase

): ArticlesService{
    override fun addArticle(request: ArticleRequest.AddArticleRequest): ArticleResponse {
        return when (val response = addArticleUseCase.invoke(request)){
            is ArticleResponse.InvalidResponse -> throw response.exception
            else -> response
        }
    }

    override fun getAllArticles(request: ArticleRequest.GetAllArticlesRequest): ArticleResponse {
        return getAllArticlesUseCase(request)
    }

    override fun updateArticle(request: ArticleRequest.UpdateArticleRequest): ArticleResponse {
        return when (val response = updateArticleUseCase(request)){
            is ArticleResponse.InvalidResponse -> throw response.exception
            else -> response
        }

    }

    override fun deleteArticle(request: ArticleRequest.DeleteArticleRequestByTitle): ArticleResponse {
        return when(val response = deleteArticleUseCase(request)){
            is ArticleResponse.InvalidResponse -> throw response.exception
            else -> response
        }
    }
}
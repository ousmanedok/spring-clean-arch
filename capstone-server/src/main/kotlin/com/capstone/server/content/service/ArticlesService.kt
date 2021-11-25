package com.capstone.server.content.service

import com.capstone.server.content.domain.AddArticleUseCase
import com.capstone.server.content.domain.GetAllArticlesUseCase
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
import org.springframework.stereotype.Service

interface ArticlesService {
    fun addArticle(request: ArticleRequest.AddArticleRequest): ArticleResponse
    fun getAllArticles(request: ArticleRequest.GetAllArticlesRequest): ArticleResponse
}

@Service("articlesService")
internal class ArticlesServiceImpl(
    val addArticleUseCase: AddArticleUseCase,
    val getAllArticlesUseCase: GetAllArticlesUseCase
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

}

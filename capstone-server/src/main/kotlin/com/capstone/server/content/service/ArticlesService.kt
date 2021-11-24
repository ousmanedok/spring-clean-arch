package com.capstone.server.content.service

import com.capstone.server.content.domain.AddArticleUseCase
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
import org.springframework.stereotype.Service

interface ArticlesService {
    fun addArticle(request: ArticleRequest.AddArticleRequest): ArticleResponse
}

@Service("articlesService")
internal class ArticlesServiceImpl(val addArticleUseCase: AddArticleUseCase): ArticlesService{
    override fun addArticle(request: ArticleRequest.AddArticleRequest): ArticleResponse {
        return when (val response = addArticleUseCase.invoke(request)){
            is ArticleResponse.InvalidResponse -> throw response.exception
            else -> response
        }
    }

}

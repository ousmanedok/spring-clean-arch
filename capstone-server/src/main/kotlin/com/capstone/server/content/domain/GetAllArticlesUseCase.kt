package com.capstone.server.content.domain

import com.capstone.server.content.data.ArticleEntity
import com.capstone.server.content.data.ArticlesDataRepository
import com.capstone.server.content.data.toArticle
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
import com.capstone.server.content.service.dto.toArticleResponseData
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Component

interface GetAllArticlesUseCase {
    operator fun invoke(request: ArticleRequest.GetAllArticlesRequest): ArticleResponse
}

@Component("getAllArticlesUseCase")
internal class GetAllArticlesUseCaseImpl(val articlesDataRepository: ArticlesDataRepository): GetAllArticlesUseCase{
    override fun invoke(request: ArticleRequest.GetAllArticlesRequest): ArticleResponse {
        val result: List<ArticleEntity> = articlesDataRepository.findAll(PageRequest.of(0,request.limit, Sort.by("publishedDate").descending())).toList()
        return ArticleResponse.ArticleListResponse(
                data = result.map { ArticleEntity ->
                    ArticleEntity.toArticle().toArticleResponseData()
                })
    }

}
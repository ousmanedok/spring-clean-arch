package com.capstone.server.content.domain

import com.capstone.server.common.exceptions.BadRequestException
import com.capstone.server.content.data.ArticleEntity
import com.capstone.server.content.data.ArticlesDataRepository
import com.capstone.server.content.data.toArticle
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
import com.capstone.server.content.service.dto.toArticleResponseData
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

interface AddArticleUseCase {
    operator fun invoke(request: ArticleRequest.AddArticleRequest): ArticleResponse
}

@Component("addArticleUseCase")
internal class AddArticleUseCaseImpl(val articleDataRepository : ArticlesDataRepository): AddArticleUseCase{
    private val log = LoggerFactory.getLogger(AddArticleUseCaseImpl::class.java)
    override fun invoke(request: ArticleRequest.AddArticleRequest): ArticleResponse {
        return if (articleDataRepository.existsByTitle(request.title)){
            ArticleResponse.InvalidResponse(BadRequestException("This article ${request.title} already exist"))
        }else{
            val article = articleDataRepository.save(
                    ArticleEntity(
                            title = request.title,
                            url = request.url,
                            content = request.content,
                            publishedDate = request.publishedDate,
                            imageUrl = request.imageUrl,
                            author = request.author
                    )
            ).toArticle()
            log.debug("Article added: $article")
            return ArticleResponse.ArticleItemResponse(
                    data = article.toArticleResponseData()
            )
        }

    }
}
package com.capstone.server.content.domain

import com.capstone.server.common.exceptions.BadRequestException
import com.capstone.server.content.data.ArticlesDataRepository
import com.capstone.server.content.data.toArticle
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
import com.capstone.server.content.service.dto.toArticleResponseData
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component


interface UpdateArticleUseCase {
    operator fun invoke(request: ArticleRequest.UpdateArticleRequest): ArticleResponse
}
@Component("updateArticleUseCase")
internal class UpdateArticleUseCaseImpl(val articlesDataRepository: ArticlesDataRepository): UpdateArticleUseCase{
    private val log = LoggerFactory.getLogger(UpdateArticleUseCaseImpl::class.java)
    override fun invoke(request: ArticleRequest.UpdateArticleRequest): ArticleResponse {
        when {
            request.title.isBlank() -> {
                return ArticleResponse.InvalidResponse(BadRequestException("Article title cannot be blank"))
            }
            else -> {
                val articleEntity = articlesDataRepository.findByTitle(request.title)
                return run {
                    log.debug(" updating article entity $articleEntity")
                    val updateEntity = articleEntity.copy(
                            url = if (!request.url.isNullOrBlank()) request.url
                                    else articleEntity.url,
                            content = if (!request.content.isNullOrBlank()) request.content
                            else articleEntity.content,
                            publishedDate = request.publishedDate ?: articleEntity.publishedDate,
                            imageUrl = if (!request.imageUrl.isNullOrBlank()) request.imageUrl
                            else articleEntity.imageUrl,
                            author = if (!request.author.isNullOrBlank()) request.author
                            else articleEntity.author,
                            siteName = if (!request.siteName.isNullOrBlank()) request.siteName
                            else articleEntity.siteName
                            )


                    log.debug("Updated values... $updateEntity")
                    val result = articlesDataRepository.save(updateEntity)
                    log.debug("Updated entity = $result")
                    ArticleResponse.ArticleItemResponse(data = result.toArticle().toArticleResponseData())
                }
            }
        }


    }

}
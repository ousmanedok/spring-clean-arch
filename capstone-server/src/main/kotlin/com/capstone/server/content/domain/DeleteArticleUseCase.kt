package com.capstone.server.content.domain

import com.capstone.server.common.exceptions.BadRequestException
import com.capstone.server.content.data.ArticlesDataRepository
import com.capstone.server.content.service.dto.ArticleRequest
import com.capstone.server.content.service.dto.ArticleResponse
import com.capstone.server.tasks.domain.usecases.DeleteTaskUseCaseImpl
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

interface DeleteArticleUseCase {
    operator fun invoke(request: ArticleRequest.DeleteArticleRequestByTitle): ArticleResponse
}
@Component("deleteArticleUseCase")
internal class DeleteArticleUseCaseImp(val articlesDataRepository: ArticlesDataRepository): DeleteArticleUseCase{
   private val log = LoggerFactory.getLogger(DeleteTaskUseCaseImpl::class.java)
    override fun invoke(request: ArticleRequest.DeleteArticleRequestByTitle): ArticleResponse {
        return when{
            request.title.isBlank() ->{
                ArticleResponse.InvalidResponse(BadRequestException("Article title cannot be blank"))
            }
            else -> {
                       when(val entity = articlesDataRepository.findByTitle(request.title)){
                           null -> {
                               ArticleResponse.InvalidResponse(BadRequestException("Article with ${request.title} does not existe"))
                           }else -> {
                               log.debug("Deleting... $entity")
                                articlesDataRepository.delete(entity)
                                ArticleResponse.DeleteArticleResponse
                           }
                       }
            }
        }
    }

}
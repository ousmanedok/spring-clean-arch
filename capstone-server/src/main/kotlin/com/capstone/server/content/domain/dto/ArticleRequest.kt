package com.capstone.server.content.domain.dto
import com.capstone.server.content.models.Article


sealed class ArticleRequest {

    data class AddArticleRequest(val article: Article): ArticleRequest()

    data class GetAllArticlesRequest( val limit: Int ? = null, val sortByDesc: Boolean = true): ArticleRequest()

    data class GetArticleRequest(val title: String): ArticleRequest()

    data class UpdateArticleRequest(
            val title: String ? = null,
            val url: String ? = null,
            val content: String ? = null,
            val imageUrl : String ? = null ,
            val author : String ? = null
    ): ArticleRequest()

    data class DeleteArticleRequestByTitle(val title: String): ArticleRequest()
}
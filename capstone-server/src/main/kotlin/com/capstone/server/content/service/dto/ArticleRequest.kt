package com.capstone.server.content.service.dto

sealed class ArticleRequest {

    data class AddArticleRequest(
            val title: String,
            val url: String,
            val content: String,
            val publishedDate : Long,
            val imageUrl : String,
            val author : String,
            val siteName : String
            ): ArticleRequest()

    data class GetAllArticlesRequest(val limit: Int? ): ArticleRequest()

    data class UpdateArticleRequest(
            val title: String,
            val url: String?,
            val content: String?,
            val publishedDate : Long?,
            val imageUrl : String?,
            val author : String?,
            val siteName: String?
    ): ArticleRequest()

    data class DeleteArticleRequestByTitle(val title: String): ArticleRequest()


}
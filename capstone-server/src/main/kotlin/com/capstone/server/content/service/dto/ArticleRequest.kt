package com.capstone.server.content.service.dto

sealed class ArticleRequest {

    data class AddArticleRequest(
            val title: String,
            val url: String,
            val content: String,
            val publishedDate : Long,
            val imageUrl : String,
            val author : String
            ): ArticleRequest()

    data class GetAllArticlesRequest(val limit: Int = 10 ): ArticleRequest()

    data class UpdateArticleRequest(
            val title: String,
            val url: String?,
            val content: String?,
            val publishedDate : Long?,
            val imageUrl : String?,
            val author : String?
    ): ArticleRequest()


}
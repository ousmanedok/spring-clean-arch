package com.capstone.server.content.domain.dto

import java.time.LocalDateTime


sealed class ArticleRequest {

    data class AddArticleRequest(
            val title: String,
            val url: String,
            val content: String,
            var publishedDate : Long,
            val imageUrl : String,
            val author : String
            ): ArticleRequest()

}
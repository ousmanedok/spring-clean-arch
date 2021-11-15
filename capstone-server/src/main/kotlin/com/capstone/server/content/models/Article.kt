package com.capstone.server.content.models

import java.time.LocalDateTime

data class Article(
        val title: String,
        val url: String,
        val content: String,
        val publishedDate : Long,
        val imageUrl : String,
        val author : String
)
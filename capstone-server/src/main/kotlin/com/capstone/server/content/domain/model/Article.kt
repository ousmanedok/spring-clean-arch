package com.capstone.server.content.domain.model

data class Article(
    val title: String,
    val url: String,
    val content: String,
    val publishedDate: Long,
    val author: String? = null,
    val imageUrl: String? = null
)
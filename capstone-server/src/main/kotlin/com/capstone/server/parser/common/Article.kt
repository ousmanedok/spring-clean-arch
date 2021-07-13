package com.capstone.server.parser.common

data class Article(
    val title: String,
    val url: String,
    val content: String,
    val publishedDate: Long,
    val author: String? = null,
    val imageUrl: String? = null
)
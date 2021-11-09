package com.capstone.server.content.models

data class Article(
        val title: String,
        val url: String,
        val content: String,
        val publishedDate : Long,
        val imageUrl : String? = null ,
        val author : String? = null
)
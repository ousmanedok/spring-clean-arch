package com.capstone.server.content.service.dto

import com.capstone.server.content.domain.models.Article

data class ArticleResponseData (
    val title: String,
    val url: String,
    val content: String,
    val publishedDate: Long,
    val imageUrl: String,
    val author: String
        )
fun Article.toArticleResponseData()= ArticleResponseData(
    title = this.title,
    url = this.url,
    content = this.content,
   publishedDate = this.publishedDate,
    imageUrl= this.imageUrl,
    author = this.author
)
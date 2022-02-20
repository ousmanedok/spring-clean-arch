package com.capstone.server.content.data

import com.capstone.server.content.domain.models.Article
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "articles")
data class ArticleEntity(
    @Id
    var id: ObjectId? = null,
    internal val title: String,
    internal val url: String,
    internal val content: String,
    internal val publishedDate: Long,
    internal val imageUrl : String? = null,
    internal val author : String,
    internal val siteName: String

)

fun Article.toArticleEntity() = ArticleEntity(
    title = this.title,
    url = this.url,
    content = this.content,
    publishedDate = this.publishedDate,
    imageUrl = this.imageUrl,
    author = this.author,
    siteName = this.siteName
)
fun ArticleEntity.toArticle() = Article(
        title = this.title,
        url = this.url,
        content = this.content,
        publishedDate = this.publishedDate,
        imageUrl = this.imageUrl,
        author = this.author,
        siteName = this.siteName
)

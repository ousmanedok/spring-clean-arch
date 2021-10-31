package com.capstone.server.articles.data

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document(collection = "articles")
data class ArticleEntity(
    @Id
    var id : ObjectId? = null,
    internal  val title : String,
    internal  val content : String,
    internal val url : String,
    internal val imageUrl : String,
    internal val author : String
)
{
    internal var publishedDate : LocalDateTime? = LocalDateTime.now()
}
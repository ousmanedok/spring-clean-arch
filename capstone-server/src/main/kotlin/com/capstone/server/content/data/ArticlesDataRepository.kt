package com.capstone.server.content.data

import com.capstone.server.content.data.ArticleEntity
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface ArticlesDataRepository: MongoRepository<ArticleEntity,ObjectId> {

    fun findByTitle(title:String): ArticleEntity?
}
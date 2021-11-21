package com.capstone.server.content.data
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticlesDataRepository: MongoRepository<ArticleEntity,ObjectId> {

    fun existsByTitle(title: String): Boolean
    fun findByTitle(title: String): ArticleEntity
}
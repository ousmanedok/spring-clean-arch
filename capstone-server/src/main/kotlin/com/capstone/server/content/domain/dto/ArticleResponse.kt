package com.capstone.server.content.domain.dto

sealed class ArticleResponse {
    data class ArticleItemResponse(val data: ArticleResponseData): ArticleResponse()

    data class ArticleListResponse(val data: List<ArticleResponseData>): ArticleResponse()

    object DeleteArticleResponse: ArticleResponse()

    data class InvalidResponse(val exception: Exception): ArticleResponse()
}
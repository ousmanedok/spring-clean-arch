package com.capstone.server.content.service.dto

sealed class ArticleResponse {

    data class ArticleItemResponse(val data: ArticleResponseData): ArticleResponse()

    data class ArticleListResponse(val data: List<ArticleResponseData>): ArticleResponse()

    data class InvalidResponse(val exception: Exception): ArticleResponse()
}
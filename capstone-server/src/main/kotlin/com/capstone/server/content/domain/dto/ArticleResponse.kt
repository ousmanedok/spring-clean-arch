package com.capstone.server.content.domain.dto

sealed class ArticleResponse {

    data class ArticleItemResponse(val data: ArticleResponseData): ArticleResponse()

    data class InvalidResponse(val exception: Exception): ArticleResponse()
}
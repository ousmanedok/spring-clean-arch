package com.capstone.server.content.parser.jsoup

data class ParsingStrategy(
    val titleSelector: String,
    val linkSelector: String,
    val authorSelector: String,
    val imageLinkSelector: String,
    val contentSelector: String,
    val publishedDateSelector: String,
    val rootDocumentSelector: String
)
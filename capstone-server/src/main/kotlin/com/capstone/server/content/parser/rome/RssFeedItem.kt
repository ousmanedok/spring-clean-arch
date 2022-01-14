package com.capstone.server.content.parser.rome

data class RssFeedItem(
        val siteName: String,
        val siteLink : String,
        val rssFeedLink : String,
        val lang: List<String>
)


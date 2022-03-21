package com.capstone.server.content.parser.rome

data class RssFeedItem(
        val siteName: String,
        val links: Links,
        val lang: List<String>
)

data class Links(
        val siteLink : String,
        val rssFeedLink : String,
)

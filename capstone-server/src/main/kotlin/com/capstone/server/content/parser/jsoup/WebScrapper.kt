package com.capstone.server.content.parser.jsoup

import com.capstone.server.content.domain.models.Article
import org.springframework.stereotype.Component

interface WebScrapper {
    operator fun invoke(websiteUrl: String, parsingStrategy: ParsingStrategy): MutableList<Article>
}

@Component("webScrapper")
internal class WebScrapperImpl(): WebScrapper {
    override fun invoke(websiteUrl: String, parsingStrategy: ParsingStrategy): MutableList<Article> {
        TODO("Not yet implemented")
    }
}
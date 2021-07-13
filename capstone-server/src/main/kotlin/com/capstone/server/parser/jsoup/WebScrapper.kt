package com.capstone.server.parser.jsoup

import com.capstone.server.parser.common.Article
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
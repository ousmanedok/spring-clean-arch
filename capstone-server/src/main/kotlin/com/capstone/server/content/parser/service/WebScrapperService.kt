package com.capstone.server.content.parser.service

import com.capstone.server.content.domain.model.Article
import com.capstone.server.content.parser.jsoup.WebScrapper
import org.springframework.stereotype.Service

interface WebScrapperService {
    fun getArticles(websiteUrl: String): List<Article>
}

@Service("webScrapperService")
internal class WebScrapperServiceImpl(
    val webScrapper: WebScrapper
) : WebScrapperService {
    override fun getArticles(websiteUrl: String): List<Article> {
        TODO("Not yet implemented")
        /**
         * Here you call webScrapper.invoke() with the parsing strategy for the website.
         * You need to go through the site by inspecting the css elements and come up with a strategy:
         * The guinee news link is here: https://guineenews.org/category/news/economie/
         * Here is a site that can give you an example of how to extract information using the elements:
         * https://blog.mestwin.net/web-scraper-and-rss-feed-generator-with-spring-boot/
         */
    }
}
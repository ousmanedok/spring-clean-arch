package com.capstone.server.service

import com.capstone.server.parser.common.Article
import com.capstone.server.parser.rome.FeedParser
import org.springframework.stereotype.Service

interface FeedService {
    fun getArticles(feedUrl: String): List<Article>
}

@Service("feedService")
internal class FeedServiceImpl(val feedParser: FeedParser) : FeedService {
    override fun getArticles(feedUrl: String): List<Article> {
       return feedParser(feedUrl)
    }

}
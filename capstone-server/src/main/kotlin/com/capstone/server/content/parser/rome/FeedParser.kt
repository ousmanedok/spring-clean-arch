package com.capstone.server.content.parser.rome

import com.capstone.server.content.domain.models.Article
import org.springframework.stereotype.Component

interface FeedParser {
    operator fun invoke(feedUrl: String): MutableList<Article>
    operator fun invoke (feedItems: List<RssFeedItem>):MutableList<Article>
}

@Component("feedParser")
internal class FeedParserImpl() : FeedParser {
    // Implement this function and you need to handle the following exceptions:
    // FeedException::class, IOException::class
    override fun invoke(feedUrl: String): MutableList<Article> {
        TODO("Not yet implemented")
    }

    override fun invoke(feedItems: List<RssFeedItem>): MutableList<Article> {
        TODO("Not yet implemented")
    }


}
package com.capstone.server.parser.rome

import com.capstone.server.parser.common.Article
import com.rometools.rome.io.FeedException
import org.springframework.stereotype.Component
import java.io.IOException
import kotlin.jvm.Throws

interface FeedParser {
    operator fun invoke(feedUrl: String): MutableList<Article>
}

@Component("feedParser")
internal class FeedParserImpl() : FeedParser {
    // Implement this function and you need to handle the following exceptions:
    // FeedException::class, IOException::class
    override fun invoke(feedUrl: String): MutableList<Article> {
        TODO("Not yet implemented")
    }

}
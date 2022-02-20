package com.capstone.server.content.parser.rome

import com.capstone.server.content.domain.models.Article
import com.rometools.rome.feed.synd.SyndEntry
import com.rometools.rome.feed.synd.SyndFeed
import com.rometools.rome.io.FeedException
import com.rometools.rome.io.SyndFeedInput
import com.rometools.rome.io.XmlReader
import org.springframework.stereotype.Component
import java.io.IOException
import java.net.URL


interface FeedParser {
    operator fun invoke(feedUrl: String): MutableList<Article>
    operator fun invoke (feedItems: List<RssFeedItem>): MutableList<Article>
}

@Component("feedParser")
internal class FeedParserImpl : FeedParser {
    @Throws( FeedException::class,IOException::class)
    override fun invoke(feedUrl: String): MutableList<Article> {
        val websiteFeed = URL(feedUrl)
        var xmlReader: XmlReader? = null
        val articles: ArrayList<Article> = ArrayList()

        try {
            xmlReader = XmlReader(websiteFeed)
            val feeder: SyndFeed = SyndFeedInput().build(xmlReader)
            val iterator: Iterator<*> = feeder.entries.iterator()
            while (iterator.hasNext()) {
                val syndEntry = iterator.next() as SyndEntry

                val patternImageUrl=  Regex(pattern = """https:?\/\/(www\.)?[a-zA-Z0-9_\/.-]+""")
                val pattern1SiteName = Regex(pattern = """(?<=https://www.).[a-zA-Z0-9_]+(?=.)""")
                val pattern2SiteName = Regex(pattern = """(?<=//).[a-zA-Z0-9_]+(?=.)""")

                val title = syndEntry.title
                val content = syndEntry.description.value
                val imageUrl = patternImageUrl.find(syndEntry.contents.toString())?.value.toString()
                val url = syndEntry.link
                val publishedDate = syndEntry.publishedDate.time
                val author = syndEntry.author
                val siteName = pattern1SiteName.find(syndEntry.link.toString())?.value
                    ?: pattern2SiteName.find(syndEntry.link.toString())?.value.toString()

                val article = Article(
                    title = title,
                    content = content,
                    imageUrl = imageUrl,
                    publishedDate = publishedDate,
                    url = url,
                    author =  author,
                    siteName = siteName
                )
                articles.add(article)
            }
        } finally {
            xmlReader?.close()
        }
        return articles

    }

    override fun invoke(feedItems: List<RssFeedItem>): MutableList<Article> {
        TODO("Not yet implemented")

    }

}
package com.capstone.server.content.parser.service

import com.capstone.server.content.domain.models.Article
import com.capstone.server.content.parser.rome.FeedParser
import org.springframework.stereotype.Service

interface FeedService {
 fun parser(feedUrl: String): MutableList<Article>
}

@Service("feedService")
internal class FeedServiceImpl(val feedParser: FeedParser) : FeedService {
 override fun parser(feedUrl: String): MutableList<Article> {
  return feedParser(feedUrl)
 }

}
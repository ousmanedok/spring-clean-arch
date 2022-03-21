package com.capstone.server.content.parser.service

import com.capstone.server.content.domain.models.Article
import com.capstone.server.content.parser.rome.FeedParser
import com.capstone.server.content.parser.rome.RssFeedItem
import org.springframework.stereotype.Service

interface FeedService {
 fun parseItem(feedUrl: String): MutableList<Article>
 fun parseItems(feedItems: List<RssFeedItem>): MutableList<Article>
}

@Service("feedService")
internal class FeedServiceImpl(val feedParser: FeedParser ) : FeedService {
 override fun parseItem(feedUrl: String): MutableList<Article> {
  return feedParser(feedUrl)
 }

 override fun parseItems(feedItems: List<RssFeedItem>): MutableList<Article> {
  return feedParser(feedItems)
 }


}
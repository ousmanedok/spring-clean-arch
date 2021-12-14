package com.capstone.server.content.parser.service

import com.capstone.server.content.domain.models.Article
import com.capstone.server.content.parser.rome.FeedParser
import org.springframework.stereotype.Service

interface FeedService {
 // TODO
}

@Service("feedService")
internal class FeedServiceImpl(val feedParser: FeedParser) : FeedService {
    //TODO
}
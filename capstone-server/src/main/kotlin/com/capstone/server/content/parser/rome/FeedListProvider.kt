package com.capstone.server.content.parser.rome

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

interface FeedListProvider {
    operator fun invoke(fileName: String): List<RssFeedItem>
}

@Component("feedListProvider")
internal class FeedListProviderImpl(var objectMapper: ObjectMapper) : FeedListProvider {
    override fun invoke(fileName: String): List<RssFeedItem> {
        var rssFeedItemList: List<RssFeedItem> = emptyList()
        objectMapper = jacksonObjectMapper()

        try {
            val file = ClassPathResource(fileName).file
            rssFeedItemList = (objectMapper.readValue(file, Array<RssFeedItem>::class.java).toList())

        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return rssFeedItemList
    }

}
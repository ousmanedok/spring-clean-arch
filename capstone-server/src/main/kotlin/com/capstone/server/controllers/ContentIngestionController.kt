package com.capstone.server.controllers

import com.capstone.server.content.domain.models.Article
import com.capstone.server.content.parser.service.WebScrapperService
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Pour tester l'application sur ta machine tu peux simplement utilizer le lien:
 * http://localhost:8080/api/ingest/feed pour extraire et afficher le contenue rss.
 * http://localhost:8080/api/ingest/scrapper pour extraire et afficher le contenue de jsoup.
 */
@RestController
@RequestMapping("/api/ingest")
class ContentIngestionController(
    val webScrapperService: WebScrapperService
) {
    private val log = LoggerFactory.getLogger(ContentIngestionController::class.java)

    @GetMapping("/feed", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun ingestFeedContent(): List<Article> {
        TODO()
    }

    @GetMapping("/scrapper", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun ingestScrappedContent(): List<Article> {
        /**
         * Cette function est pour jsoup.
         * Pour le moment appelle seulement la function webScrapperService.invoke(...)
         * et tu dois aussi implementer cette function
         */
        TODO()
    }

}
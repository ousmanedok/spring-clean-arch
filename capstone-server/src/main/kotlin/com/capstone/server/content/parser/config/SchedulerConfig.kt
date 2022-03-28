package com.capstone.server.content.parser.config

import com.capstone.server.content.domain.models.Article
import com.capstone.server.content.parser.service.FeedService
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalTime

@Component
@Configuration
@EnableScheduling
@EnableAsync
@ConditionalOnProperty(name= ["scheduler.enabled"], matchIfMissing = true)
class ScheduleConfig(val feedService: FeedService) {
    private val log = LoggerFactory.getLogger(ScheduleConfig::class.java)

    @Scheduled(fixedRateString = "\${fixedRate.value}", initialDelayString = "\${initialDelay.value}" )
    fun initialDelay(){
        log.debug("Start up")
    }

    @Async
    @Scheduled(cron = "\${cron.expression.value}", zone = "\${timezone}")
    fun schedulerCronJobToSaveArticles() {
        feedService.saveArticles("rssfeedlist.json")
        log.debug("Articles are saved successfull into data base")
    }
}
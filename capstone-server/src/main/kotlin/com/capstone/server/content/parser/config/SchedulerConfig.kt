package com.capstone.server.content.parser.config

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
class ScheduleConfig() {
    private val log = LoggerFactory.getLogger(ScheduleConfig::class.java)

    @Scheduled(fixedRateString = "\${fixedRate.value}", initialDelayString = "\${initialDelay.value}" )
    fun initialDelay(){
        log.debug("Start up")
    }

    @Async
    @Scheduled(cron = "\${cron.expression.value}", zone = "\${timezone}")
    fun scheduleCronJob() {
        log.debug("Task with Cron Expression, " + LocalTime.now().minute)
    }
}
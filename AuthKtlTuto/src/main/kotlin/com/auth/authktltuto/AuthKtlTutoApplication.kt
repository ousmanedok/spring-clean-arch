package com.auth.authktltuto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class AuthKtlTutoApplication

fun main(args: Array<String>) {
    runApplication<AuthKtlTutoApplication>(*args)
}

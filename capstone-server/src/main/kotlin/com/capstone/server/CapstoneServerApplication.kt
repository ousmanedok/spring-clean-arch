package com.capstone.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class CapstoneServerApplication

fun main(args: Array<String>) {
    runApplication<CapstoneServerApplication>(*args)
}

@RestController
class HelloWorld {

    @GetMapping("/hello")
    fun sayHello() = "Hello from Spring boot"
}
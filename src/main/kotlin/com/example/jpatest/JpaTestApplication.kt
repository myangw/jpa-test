package com.example.jpatest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaTestApplication

fun main(args: Array<String>) {
    runApplication<JpaTestApplication>(*args)
}

package com.yzq.bsdiffserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class BsDiffServerApplication

fun main(args: Array<String>) {
    runApplication<BsDiffServerApplication>(*args)
}
package com.yzq.kotlinspringbootkts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.yzq.kotlinspringbootkts"])
class KotlinSpringbootKtsApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringbootKtsApplication>(*args)
}

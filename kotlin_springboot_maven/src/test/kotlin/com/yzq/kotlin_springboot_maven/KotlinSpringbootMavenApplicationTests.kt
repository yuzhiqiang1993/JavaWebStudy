package com.yzq.kotlin_springboot_maven

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KotlinSpringbootMavenApplicationTests {

    @Test
    fun contextLoads() {
    }


    @Test
    suspend fun testCoroutine() = coroutineScope {
        println("asdasdas")
        println("Thread.currentThread().name = ${Thread.currentThread().name}")
        val differed1 = async {
            delay(1000)
            1
        }

        val differed2 = async {
            delay(2000)
            2
        }


        val awaitAll = awaitAll(differed1, differed2)

        val sum = awaitAll.sum()


        println("sum = ${sum}")
    }
}

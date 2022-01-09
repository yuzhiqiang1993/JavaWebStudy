package com.yzq.kotlin_springboot_maven

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.yzq.kotlin_springboot_maven.dao.mapper")
class KotlinSpringbootMavenApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringbootMavenApplication>(*args)
}

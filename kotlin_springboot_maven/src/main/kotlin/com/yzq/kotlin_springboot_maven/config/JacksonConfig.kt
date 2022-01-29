package com.yzq.kotlin_springboot_maven.config

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Configuration
class JacksonConfig {
    @Value("\${spring.jackson.date-format}")
    private val pattern: String? = null

    @Bean
    fun localDateTimeDeserializer(): LocalDateTimeSerializer? {
        return LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern))
    }

    @Bean
    fun jackson2ObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer? {
        return Jackson2ObjectMapperBuilderCustomizer { builder: Jackson2ObjectMapperBuilder ->
            builder.serializerByType(
                LocalDateTime::class.java, localDateTimeDeserializer()!!)
        }
    }

}
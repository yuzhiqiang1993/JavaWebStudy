package com.yzq.kotlin_springboot_maven.config

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
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
                LocalDateTime::class.java, localDateTimeDeserializer()!!
            )
        }
    }

    @Bean
    fun mappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
        return MappingJackson2HttpMessageConverter(jacksonObjectMapper().registerModule(JavaTimeModule()))
    }

}
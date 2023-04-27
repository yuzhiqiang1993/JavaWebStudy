package com.yzq.kotlinspringbootkts.config

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


/**
 * @description: jackson的配置
 * @author : yuzhiqiang
 * @date   : 2023/1/17
 * @time   : 16:12
 */

@Configuration
class JacksonConfig {
    @Value("\${spring.jackson.date-format}")
    private val pattern: String? = null


    @Bean
//    @Primary
    fun jackson2ObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer {
        return Jackson2ObjectMapperBuilderCustomizer {
            println("jackson2ObjectMapperBuilderCustomizer:$it,  pattern:$pattern")
            it.apply {
//                deserializerByType(
//                    LocalDateTime::class.java,
//                    LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(pattern))
//                )
                /*序列化（对象转json）时处理 LocalDateTime 类型的数据 将其Format以下 避免返回的日期数据带T*/
                serializerByType(
                    LocalDateTime::class.java,
                    LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern))
                )
            }
        }
    }

//    @Bean
//    fun mappingJackson2HttpMessageConverter(): MappingJackson2HttpMessageConverter {
//        return MappingJackson2HttpMessageConverter(jacksonObjectMapper().registerModule(JavaTimeModule()))
//    }

}

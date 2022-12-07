package com.yzq.kotlin_springboot_maven.annotation

import com.yzq.kotlin_springboot_maven.validator.StringContainsValidator
import java.lang.annotation.Documented
import javax.validation.Constraint
import kotlin.reflect.KClass


@Documented
@Constraint(validatedBy = [StringContainsValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class StringContains(
    val message: String = "参数异常",
    val limitValues: Array<String> = [],
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<*>> = []

)

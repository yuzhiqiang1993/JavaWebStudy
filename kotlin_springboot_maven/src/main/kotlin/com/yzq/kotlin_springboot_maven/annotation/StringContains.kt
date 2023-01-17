package com.yzq.kotlin_springboot_maven.annotation

import com.yzq.kotlin_springboot_maven.validator.StringContainsValidator
import javax.validation.Constraint
import kotlin.reflect.KClass


/**
 * @description: 校验参数值是否是给定集合中的数据
 * @author : yuzhiqiang
 * @date   : 2023/1/17
 * @time   : 16:11
 */

@MustBeDocumented
@Constraint(validatedBy = [StringContainsValidator::class])
@Target(AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class StringContains(
    val message: String = "参数异常",
    val limitValues: Array<String> = [],
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<*>> = []

)

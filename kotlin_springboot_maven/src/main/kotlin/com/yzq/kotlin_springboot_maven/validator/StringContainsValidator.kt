package com.yzq.kotlin_springboot_maven.validator

import com.yzq.kotlin_springboot_maven.annotation.StringContains
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext


/**
 * @description: 校验值是否是给定集合中的数据
 * @author : yuzhiqiang
 * @date   : 2023/1/17
 * @time   : 16:10
 */

class StringContainsValidator : ConstraintValidator<StringContains, String> {


    private lateinit var limitValues: Set<String>
    override fun initialize(constraintAnnotation: StringContains) {
        super.initialize(constraintAnnotation)

        limitValues = constraintAnnotation.limitValues.toSet()

        println("limitValues:$limitValues")
    }

    override fun isValid(value: String, context: ConstraintValidatorContext): Boolean {
        println("isValid:$value")
        /*value是否在集合中*/
        return limitValues.contains(value)
    }


}

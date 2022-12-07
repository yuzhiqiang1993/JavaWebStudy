package com.yzq.kotlin_springboot_maven.validator

import com.yzq.kotlin_springboot_maven.annotation.StringContains
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class StringContainsValidator : ConstraintValidator<StringContains, String> {


    private lateinit var limitValues: Set<String>
    override fun initialize(constraintAnnotation: StringContains) {
        super.initialize(constraintAnnotation)

        limitValues = constraintAnnotation.limitValues.toSet()

        println("limitValues:$limitValues")
    }

    override fun isValid(value: String, context: ConstraintValidatorContext): Boolean {
        println("isValid:$value")
        return limitValues.contains(value)
    }


}

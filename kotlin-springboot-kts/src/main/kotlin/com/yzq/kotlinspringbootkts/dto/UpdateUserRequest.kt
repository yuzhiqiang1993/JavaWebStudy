package com.yzq.kotlinspringbootkts.dto

data class UpdateUserRequest(
    val name: String,
    val age: Int,
    val gender: String,
    val enable: Int = 1
)
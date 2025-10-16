package com.yzq.kotlinspringbootkts.dto

data class CreateUserRequest(
    val name: String,
    val age: Int,
    val gender: String,
    val enable: Int = 1
)
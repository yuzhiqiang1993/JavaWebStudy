package com.yzq.kotlinspringbootkts.data

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.FieldStrategy
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime

data class User(
    @TableId(type = IdType.AUTO)
    val id: Long,
    val name: String = "",
    val age: Int = -1,
    val gender: String = "",
    @TableField(value = "create_time", fill = FieldFill.INSERT, insertStrategy = FieldStrategy.NOT_NULL)
//    @JsonFormat(pattern = "yyyy")
    val createTime: LocalDateTime?,
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE, insertStrategy = FieldStrategy.NOT_NULL, updateStrategy = FieldStrategy.NOT_NULL)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    var updateTime: LocalDateTime?,
    @JsonIgnore
    var enable: Int = 1,
)

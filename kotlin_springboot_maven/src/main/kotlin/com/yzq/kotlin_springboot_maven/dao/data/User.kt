package com.yzq.kotlin_springboot_maven.dao.data

import com.baomidou.mybatisplus.annotation.FieldFill
import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.fasterxml.jackson.annotation.JsonFilter
import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime


data class User(
    @TableId(type = IdType.AUTO)
    val id: Long,
    val name: String = "",
    val age: Int = -1,
    val gender: String = "",
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy")
    val createTime: LocalDateTime?,
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    var updateTime: LocalDateTime?,
    @JsonIgnore
    var enable: Int = 1,
)

package com.yzq.kotlinspringbootkts.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.yzq.kotlinspringbootkts.data.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User> {
}

package com.yzq.kotlin_springboot_maven.service

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.yzq.kotlin_springboot_maven.dao.data.User
import com.yzq.kotlin_springboot_maven.dao.mapper.UserMapper
import com.yzq.kotlin_springboot_maven.data.request.UserPageReq
import com.yzq.kotlin_springboot_maven.data.resp.PageResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService : ServiceImpl<UserMapper, User>() {

    @Autowired
    private lateinit var userMapper: UserMapper

    fun pageList(pageReq: UserPageReq): PageResult<List<User>> {
        pageReq.checkData()
        val pageResult = PageResult<List<User>>()

        val pageSize = pageReq.pageSize


        /*先查数量*/
        val count = userMapper.queryCount(pageReq.searchKey)
        pageResult.totalCount = count
        if (count == 0L) {
            return pageResult
        }

        /*查具体数据*/
        val start = (pageReq.pageNum - 1) * pageSize
        val list = userMapper.pageList(pageReq.searchKey, start, pageSize)
        pageResult.totalPage = (count + pageSize - 1) / pageSize
        pageResult.data = list

        return pageResult
    }


}
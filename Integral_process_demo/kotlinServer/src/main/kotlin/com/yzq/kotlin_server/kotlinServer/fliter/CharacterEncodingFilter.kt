package com.yzq.kotlin_server.kotlinServer.fliter

import javax.naming.Name
import javax.servlet.*
import javax.servlet.annotation.WebFilter


/**
 * @description: 字符自编码过滤器
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/4/4
 * @time   : 20:26
 */

@WebFilter(filterName = "characterEncodingFilter", urlPatterns = ["/*"])
class CharacterEncodingFilter : Filter {

    override fun init(filterConfig: FilterConfig?) {
        super.init(filterConfig)
        println("CharacterEncodingFilter.init")
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        println("CharacterEncodingFilter.doFilter")
        request.characterEncoding = "utf-8"
        response.characterEncoding = "utf-8"
        chain.doFilter(request, response)
    }
}
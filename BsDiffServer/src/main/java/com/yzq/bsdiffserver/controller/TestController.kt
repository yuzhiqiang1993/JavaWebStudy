package com.yzq.bsdiffserver.controller

import com.yzq.bsdiffserver.data.BaseResp
import com.yzq.bsdiffserver.service.BsDiffService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress
import java.net.UnknownHostException

@RestController
@RequestMapping("/test")
class TestController {
    @GetMapping("/test")
    fun test(): String {
        var hostAddress = ""
        try {
            println("Runtime.getRuntime().availableProcessors() = " + Runtime.getRuntime().availableProcessors())
            val localHost = InetAddress.getLocalHost()
            hostAddress = localHost.hostAddress
        } catch (e: UnknownHostException) {
            e.printStackTrace()
        }
        return "可以正常访问 hostAddress:$hostAddress"
    }

    @GetMapping("/testBsDiff")
    fun testBsDiff(@RequestParam fileName: String, @RequestParam suffix: String): BaseResp<String> {
        val baseResp = BaseResp<String>()
        val timeMillis = System.currentTimeMillis()
        try {
            BsDiffService.testBsDiff(fileName, suffix)
            baseResp.data = "完成"
        } catch (e: Exception) {
            e.printStackTrace()
            baseResp.msg = e.localizedMessage
        } finally {
            baseResp.time = System.currentTimeMillis() - timeMillis
        }
        return baseResp
    }
}
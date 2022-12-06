package com.yzq.kotlin_springboot_maven.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.io.File

@RestController
@RequestMapping("/img")
class ImageController {

    @PostMapping("/uploadImg")
    @ResponseBody
    fun uploadImg(@RequestParam("image") image: MultipartFile, key1: String, key2: Boolean, key3: Int): String {
        /*获取传过来的参数*/
        println("key1:${key1}")
        println("key2:${key2}")
        println("key3:${key3}")
        println("fileName:${image.originalFilename}")
        /*保存图片到本地*/
        val projectPath = System.getProperty("user.dir")
        println("projectPath = ${projectPath}")
        val filePath =
            "${projectPath}${File.separator}tmp${File.separator}img${File.separator}${image.originalFilename}"
        println(filePath)
        val file = File(filePath)
        if (!file.exists()) {
            file.mkdirs()
        }
        image.transferTo(file)

        return "成功"
    }
}

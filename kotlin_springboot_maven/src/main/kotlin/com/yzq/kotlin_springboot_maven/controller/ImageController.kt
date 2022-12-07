package com.yzq.kotlin_springboot_maven.controller

import com.yzq.kotlin_springboot_maven.annotation.StringContains
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import javax.validation.ConstraintViolationException

@RestController
@RequestMapping("/img")
@Validated
class ImageController {

    @PostMapping("/uploadImg")
    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseBody
    fun uploadImg(
        @RequestParam("image") image: MultipartFile,
        @StringContains(limitValues = ["front1", "back"]) key1: String,
        key2: Boolean,
        key3: Int
    ): String {
        var result = "成功"
        try {

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

        } catch (e: Exception) {
            e.printStackTrace()
            result = e.message ?: "失败"
        }

        return result
    }
}

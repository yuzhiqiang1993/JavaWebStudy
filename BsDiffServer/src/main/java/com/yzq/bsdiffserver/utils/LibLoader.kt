package com.yzq.bsdiffserver.utils

import org.springframework.core.io.ClassPathResource
import org.springframework.util.FileCopyUtils
import java.io.File
import java.io.FileOutputStream

/**
 * @description: 用来load so文件，先将项目的so拷贝到linux中，然后加载
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/12/18
 * @time   : 14:33
 */
object LibLoader {
    fun loadLib(libName: String, resourcePath: String) {
        println("libName = $libName")
        println("resourcePath = $resourcePath")

        /*获取当前项目所在的linux路径 示例：/home/admin/webapp */
        val projectPath = System.getProperty("user.dir")
        println("projectPath = $projectPath")

        /*创建一个目录 用来放so*/
        val nativeLibPath =
            projectPath + File.separator + "tmp" + File.separator + "bsdiffdemo" + File.separator + "lib" + File.separator
        val nativeLibFolder = File(nativeLibPath)
        if (!nativeLibFolder.exists()) {
            nativeLibFolder.mkdirs()
        }
        /*用来存放临时文件的目录*/
        val filePath =
            projectPath + File.separator + "tmp" + File.separator + "bsdiffdemo" + File.separator + "file" + File.separator
        val fileFolder = File(filePath)
        if (!fileFolder.exists()) {
            fileFolder.mkdirs()
        }
        val libFile = File(nativeLibFolder, libName)
        println("libFile.getAbsolutePath() = " + libFile.absolutePath)
        if (libFile.exists()) {
            println("libFile 文件存在 libFile.getAbsolutePath() = " + libFile.absolutePath)
            System.load(libFile.absolutePath)
        } else {
            try {
                val inputStream = ClassPathResource(resourcePath).inputStream
                //                InputStream in = LibLoader.class.getResourceAsStream(resourcePath);
                val fileOutputStream = FileOutputStream(libFile)

                /*把文件存到临时目录里*/
                val copy = FileCopyUtils.copy(inputStream, fileOutputStream)
                println("copy result= $copy")
                inputStream.close()
                fileOutputStream.close()
                println("libFile.getAbsolutePath() = " + libFile.absolutePath)
                System.load(libFile.path)
            } catch (e: Exception) {
                e.printStackTrace()
                throw RuntimeException("Failed to load required lib", e)
            }
        }
    }
}
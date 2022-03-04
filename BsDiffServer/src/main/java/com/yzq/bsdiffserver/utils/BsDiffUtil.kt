package com.yzq.bsdiffserver.utils

import java.io.File

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: BsDiffUtil
 * @date : 2021/12/18
 * @time : 14:33
 */
object BsDiffUtil {
    init {
        val systemType = System.getProperty("os.name")
        println("systemType = $systemType")
        try {
            /*获取当前项目所在的linux路径 示例：/home/admin/webapp */
//            final String projectPath = System.getProperty("user.dir");
            val libPath = "lib${File.separator}libxeon_bsdiff.so"
            val libName = "libxeon_bsdiff.so"

            /*mac上使用dylib*/
//            String libPath = "lib" + File.separator + "libxeon_bsdiff.dylib";
//            String libName = "libxeon_bsdiff.dylib";
            LibLoader.loadLib(libName, libPath)
            println("load so success")
        } catch (e: Exception) {
            println("e = " + e.message)
            e.printStackTrace()
        }
    }

    /**
     * 生成补丁文件
     *
     * @param newFilePath
     * @param oldFilePath
     * @param patchFilePath
     * @return
     */
    external fun fileDiff(newFilePath: String, oldFilePath: String, patchFilePath: String): Int

    /**
     * 合并文件
     *
     * @param oldFilePath
     * @param patchFilePath
     * @param combineFilePath
     * @return
     */
    external fun filePatch(oldFilePath: String, patchFilePath: String, combineFilePath: String): Int
}
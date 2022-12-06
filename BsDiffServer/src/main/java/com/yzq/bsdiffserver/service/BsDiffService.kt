package com.yzq.bsdiffserver.service

import com.yzq.bsdiffserver.utils.BsDiffUtil
import java.io.File

/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 测试类
 * @date : 2021/12/18
 * @time : 14:55
 */
object BsDiffService {
    fun testBsDiff(fileName: String, suffix: String) {
        try {

            /*测试load so*/
//            BsDiffUtil.test();
            val projectPath = System.getProperty("user.dir")
            println("projectPath = ${projectPath}")
            val filePath =
                "${projectPath}${File.separator}tmp${File.separator}bsdiffdemo${File.separator}file${File.separator}"


            /*旧文件路径*/



//            String testName = "mall_boxs_animations";
//            String testName = "libeffect";
//            String testName = "libeffect";
//            String end = ".so";
            val oldFilePath = "${filePath}${fileName}_old.${suffix}"
            /*新文件*/
            val newFilePath = "${filePath}${fileName}_new.${suffix}"
            /*补丁文件*/
            val patchFilePath = "${filePath}${fileName}_patch.${suffix}"
            /*合并后的文件*/
            val combineFilePath = "${filePath}${fileName}_combine.${suffix}"
            println("oldFilePath = $oldFilePath")
            println("newFilePath = $newFilePath")
            println("patchFilePath = $patchFilePath")
            println("combineFilePath = $combineFilePath")

            /*生成补丁文件*/
            val timeMillis = System.currentTimeMillis()
            println("正在生成补丁文件，请稍后，具体时跟文件大小有关")
            val diffResult = BsDiffUtil.fileDiff(newFilePath, oldFilePath, patchFilePath)
            println("补丁文件生成结束 code = ${diffResult}  耗时:${System.currentTimeMillis() - timeMillis}")

            val millis = System.currentTimeMillis()
            println("正在合并补丁文件，请稍后，具体时跟文件大小有关")
            /*合并补丁文件*/
            val patchResult = BsDiffUtil.filePatch(oldFilePath, patchFilePath, combineFilePath)
            println("合并文件结束 code = ${patchResult}耗时：${System.currentTimeMillis() - millis}")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

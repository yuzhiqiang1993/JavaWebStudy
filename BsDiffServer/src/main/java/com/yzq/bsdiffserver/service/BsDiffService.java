package com.yzq.bsdiffserver.service;


import com.yzq.bsdiffserver.utils.BsDiffUtil;

import java.io.File;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: 测试类
 * @date : 2021/12/18
 * @time : 14:55
 */
public class BsDiffService {

    public static void testBsDiff() {
        try {

            /*测试load so*/
//            BsDiffUtil.test();

            final String projectPath = System.getProperty("user.dir");
            String filePath = projectPath + File.separator + "tmp" + File.separator + "bsdiffdemo" + File.separator + "file" + File.separator;
            /*旧文件路径*/


//            String testName = "mall_boxs_animations";
//            String testName = "libeffect";
            String testName = "app_release_du";
            String end = ".apk";

            String oldFilePath = filePath + testName + "_old" + end;
            /*新文件*/
            String newFilePath = filePath + testName + "_new" + end;
            /*补丁文件*/
            String patchFilePath = filePath + testName + "_patch" + end;
            /*合并后的文件*/
            String combineFilePath = filePath + testName + "_combine" + end;

            System.out.println("oldFilePath = " + oldFilePath);
            System.out.println("newFilePath = " + newFilePath);
            System.out.println("patchFilePath = " + patchFilePath);
            System.out.println("combineFilePath = " + combineFilePath);

            /*生成补丁文件*/
            final long timeMillis = System.currentTimeMillis();
            System.out.println("正在生成补丁文件，请稍后，具体时跟文件大小有关");
            final int diffResult = BsDiffUtil.fileDiff(newFilePath, oldFilePath, patchFilePath);
            System.out.println("补丁文件生成结束 code = " + diffResult + "   耗时:" + (System.currentTimeMillis() - timeMillis));


            final long millis = System.currentTimeMillis();
            System.out.println("正在合并补丁文件，请稍后，具体时跟文件大小有关");
            /*合并补丁文件*/
            final int patchResult = BsDiffUtil.filePatch(oldFilePath, patchFilePath, combineFilePath);
            System.out.println("合并文件结束 code = " + patchResult + "耗时：" + (System.currentTimeMillis() - millis));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

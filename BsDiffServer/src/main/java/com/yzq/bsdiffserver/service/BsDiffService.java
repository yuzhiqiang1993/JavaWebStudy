package com.yzq.bsdiffserver.service;


import com.yzq.bsdiffserver.utils.BsDiffUtil;

import java.io.File;


/**
 * @description: 测试类
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/12/18
 * @time   : 14:55
 */
public class BsDiffService {

    public static void testBsDiff() {
        try {

            /*测试load so*/
//            BsDiffUtil.test();

            final String projectPath = System.getProperty("user.dir");
            String filePath = projectPath + File.separator + "tmp" + File.separator + "bsdiffdemo" + File.separator + "file" + File.separator;
            /*旧文件路径*/

            String oldFilePath = filePath + "old.txt";
            /*新文件*/
            String newFilePath = filePath + "new.txt";
            /*补丁文件*/
            String patchFilePath = filePath + "patch.txt";
            /*合并后的文件*/
            String combineFilePath = filePath + "combine.txt";

            System.out.println("oldFilePath = " + oldFilePath);
            System.out.println("newFilePath = " + newFilePath);
            System.out.println("patchFilePath = " + patchFilePath);
            System.out.println("combineFilePath = " + combineFilePath);

            /*生成补丁文件*/
            final int diffResult = BsDiffUtil.fileDiff(newFilePath, oldFilePath, patchFilePath);
            System.out.println("diffResult = " + diffResult);

            /*合并补丁文件*/
            final int patchResult = BsDiffUtil.filePatch(oldFilePath, patchFilePath, combineFilePath);
            System.out.println("patchResult = " + patchResult);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

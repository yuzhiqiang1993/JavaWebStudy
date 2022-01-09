package com.yzq.bsdiffserver.utils;

import java.io.File;


/**
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @description: BsDiffUtil
 * @date : 2021/12/18
 * @time : 14:33
 */
public class BsDiffUtil {

    static {
        String systemType = System.getProperty("os.name");
        System.out.println("systemType = " + systemType);
        try {
            /*获取当前项目所在的linux路径 示例：/home/admin/webapp */
//            final String projectPath = System.getProperty("user.dir");
            String libPath = "lib" + File.separator + "libxeon_bsdiff.so";
            String libName = "libxeon_bsdiff.so";

            /*mac上使用dylib*/
//            String libPath = "lib" + File.separator + "libxeon_bsdiff.dylib";
//            String libName = "libxeon_bsdiff.dylib";
            LibLoader.loadLib(libName, libPath);
            System.out.println("load so success");

        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            e.printStackTrace();
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
    public static native int fileDiff(String newFilePath, String oldFilePath, String patchFilePath);

    /**
     * 合并文件
     *
     * @param oldFilePath
     * @param patchFilePath
     * @param combineFilePath
     * @return
     */
    public static native int filePatch(String oldFilePath, String patchFilePath, String combineFilePath);
}

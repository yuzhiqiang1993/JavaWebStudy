package com.yzq.bsdiffserver.utils;

import java.io.File;

public class BsDiffUtil {

    private static final String projectPath = System.getProperty("user.dir");

    static {
        String systemType = System.getProperty("os.name");
        System.out.println("systemType = " + systemType);
        try {

            /*获取当前项目所在的linux路径 示例：/home/admin/webapp */
//            final String projectPath = System.getProperty("user.dir");

            String libPath = "lib" + File.separator + "libxeon_bsdiff.so";
            String libName = "libxeon_bsdiff.so";


//            String libPath = "lib" + File.separator + "libxeon_bsdiff.dylib";
//            String libName = "libxeon_bsdiff.dylib";
            LibLoader.loadLib(libName, libPath);
            System.out.println("load so success");

        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static void test() {
        System.out.println("test");
    }


    public static native int fileDiff(String newFilePath, String oldFilePath, String patchFilePath);

    public static native int filePatch(String oldFilePath, String patchFilePath, String combineFilePath);
}

package com.yzq.bsdiffserver.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;

public class BsDiffUtil {

    static {
        String systemType = System.getProperty("os.name");
        System.out.println("systemType = " + systemType);
        try {
            final Resource classPathResource = new ClassPathResource("lib" + File.separator + "libxeon_bsdiff.dylib");
            final File file = classPathResource.getFile();
            System.out.println("file.getPath() = " + file.getPath());
            System.load(file.getPath());
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            e.printStackTrace();
        }

    }


    public static native int fileDiff(String newFilePath, String oldFilePath, String patchFilePath);

    public static native int filePatch(String oldFilePath, String patchFilePath, String combineFilePath);
}

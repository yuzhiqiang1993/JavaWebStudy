package com.yzq.bsdiffserver.service;


import com.yzq.bsdiffserver.utils.BsDiffUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;

public class BsDiffService {

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

    public static void testBsDiff() {
        try {


            final Resource oldPathResource = new ClassPathResource("static" + File.separator + "old.txt");
            final File oldFile = oldPathResource.getFile();
            final Resource newPathResource = new ClassPathResource("static" + File.separator + "new.txt");
            final File newFile = newPathResource.getFile();


            String path = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "patch.txt";

            final File patchFile = new File(path);
            System.out.println("patchFile.getPath() = " + patchFile.getAbsolutePath());
//
            final int fileDiffResult = BsDiffUtil.fileDiff(newFile.getAbsolutePath(), oldFile.getPath(), patchFile.getAbsolutePath());
            System.out.println("fileDiffResult = " + fileDiffResult);

            /*合并文件*/
            String combineFilePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "combine.txt";

            final File combineFile = new File(combineFilePath);

            final int filePatchResult = BsDiffUtil.filePatch(oldFile.getAbsolutePath(), patchFile.getAbsolutePath(), combineFile.getAbsolutePath());


            System.out.println("filePatchResult = " + filePatchResult);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

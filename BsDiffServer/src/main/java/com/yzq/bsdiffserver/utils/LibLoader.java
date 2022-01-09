package com.yzq.bsdiffserver.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


/**
 * @description: 用来load so文件，先将项目的so拷贝到linux中，然后加载
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 * @date   : 2021/12/18
 * @time   : 14:33
 */
public class LibLoader {
    public static void loadLib(String libName, String resourcePath) {

        System.out.println("libName = " + libName);
        System.out.println("resourcePath = " + resourcePath);

        /*获取当前项目所在的linux路径 示例：/home/admin/webapp */
        final String projectPath = System.getProperty("user.dir");

        System.out.println("projectPath = " + projectPath);

        /*创建一个目录 用来放so*/
        String nativeLibPath = projectPath + File.separator + "tmp" + File.separator + "bsdiffdemo" + File.separator + "lib" + File.separator;

        File nativeLibFolder = new File(nativeLibPath);
        if (!nativeLibFolder.exists()) {
            nativeLibFolder.mkdirs();
        }
        /*用来存放临时文件的目录*/
        String filePath = projectPath + File.separator + "tmp" + File.separator + "bsdiffdemo" + File.separator + "file" + File.separator;
        File fileFolder = new File(filePath);
        if (!fileFolder.exists()) {
            fileFolder.mkdirs();
        }

        File libFile = new File(nativeLibFolder, libName);
        System.out.println("libFile.getAbsolutePath() = " + libFile.getAbsolutePath());
        if (libFile.exists()) {
            System.out.println("libFile 文件存在 libFile.getAbsolutePath() = " + libFile.getAbsolutePath());
            System.load(libFile.getAbsolutePath());
        } else {
            try {

                final InputStream inputStream = new ClassPathResource(resourcePath).getInputStream();
//                InputStream in = LibLoader.class.getResourceAsStream(resourcePath);
                final FileOutputStream fileOutputStream = new FileOutputStream(libFile);

                /*把文件存到临时目录里*/
                final int copy = FileCopyUtils.copy(inputStream, fileOutputStream);

                System.out.println("copy result= " + copy);
                inputStream.close();
                fileOutputStream.close();
                System.out.println("libFile.getAbsolutePath() = " + libFile.getAbsolutePath());
                System.load(libFile.getPath());


            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to load required lib", e);
            }
        }
    }
}
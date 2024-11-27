package com.yupi.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {
    public static void copyFilesByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
        /**
         * 先调用：
         * public static File copy(String srcPath, String destPath, boolean isOverride) throws IORuntimeException {
         *         return copy(file(srcPath), file(destPath), isOverride);
         * }
         * 再调用：
         * public static File copy(File src, File dest, boolean isOverride) throws IORuntimeException {
         *         return FileCopier.create(src, dest).setOverride(isOverride).copy();
         * }
         * 1.其中src和dest均为目录时，src目录及其目录下所有文件目录拷贝到dest下
         * 2.其中src和dest均为文件时，直接赋值，名字为dest
         * 3.其中src为文件，dest为目录时，将src拷贝到dest目录下
         * 4.isOverride表示是否覆盖目标文件！
         */
    }

    public static void main(String[] args) {
        /**
         * System.getProperty("user.dir")：
         *      1.其中user.dir是一个系统属性
         *      2.这是 Java 中的一个方法调用，用于获取当前用户的工作目录。
         *      3.如果在命令行中从某个特定文件夹启动 Java 程序，这个方法将返回那个文件夹的路径。
         *      4.在集成开发环境中运行项目时，通常是项目在 IDE 中的根目录。
         */
        //获取整个项目的根目录
        String projectPath = System.getProperty("user.dir");//E:\学习资料\高级\代码存档\yuzi-generator\yupi-generator-basic
        File parentFile = new File(projectPath).getParentFile();//E:\学习资料\高级\代码存档\yuzi-generator

        //输入路径：acm示例代码模板目录
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();

        //输出路径：直接输出到项目的根目录
        String outputPath = projectPath;
        copyFilesByHutool(inputPath,outputPath);
    }
}

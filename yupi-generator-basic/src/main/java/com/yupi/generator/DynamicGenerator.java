package com.yupi.generator;

import com.yupi.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicGenerator {
    //进行代码的完善优化：健壮性，灵活性两个方面考虑！
    public static void doGenerate(String inputPath,String outputPath,Object model){
        //新建configuration对象，参数为freemarker版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        Writer fileWriter = null;

        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        try {
            //指定模板文件所在的路径
            File templateDir = new File(inputPath).getParentFile();
            configuration.setDirectoryForTemplateLoading(templateDir);

            //准备好模板文件后，通过创建template对象来加载该模板
            String templateName = new File(inputPath).getName();
            Template template = configuration.getTemplate(templateName);

            //指定生成的文件
            fileWriter = new FileWriter(outputPath);

            //生成文件
            template.process(model,fileWriter);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null!=fileWriter){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
        String projectPath = System.getProperty("user.dir");
        String inputPath = projectPath+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath+File.separator+"MainTemplate.java";

        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setOutputText("求和结果：");

        doGenerate(inputPath,outputPath,mainTemplateConfig);
    /**
        //新建configuration对象，参数为freemarker版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);


        //指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));


        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");


        //准备好模板文件后，通过创建template对象来加载该模板
        Template template = configuration.getTemplate("MainTemplate.java.ftl");


        //创建数据模型(推荐使用hashmap)
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setOutputText("求和结果：");


        //指定生成的文件
        Writer fileWriter = new FileWriter("MainTemplate.java");//在与src同级的位置生成

        //生成文件
        template.process(mainTemplateConfig,fileWriter);

        fileWriter.close();
     */
    }
}

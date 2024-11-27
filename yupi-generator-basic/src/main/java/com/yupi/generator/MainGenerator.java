package com.yupi.generator;

import cn.hutool.core.thread.ExecutorBuilder;
import com.yupi.model.MainTemplateConfig;

import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainGenerator {
    /**
     * 线程池：
     *      1.核心参数：
     *          核心线程数：线程池中始终保持存活的线程数量。即使这些线程处于空闲状态，它们也不会被销毁，除非设置了allowCoreThreadTimeOut为true！
     *          最大线程数：线程池中允许的最大线程数量！
     *          线程存活时间：当线程池中的线程数量超过核心线程数时，多余的空闲线程在没有任务可执行的情况下保持存活的时间。
     *          时间单位：用于指定 keepAliveTime 的时间单位，是一个java.util.concurrent.TimeUnit枚举类型的值。
     *          任务队列：用于存储等待执行的任务的队列。
     *          线程工厂：用于创建新线程的工厂。
     *          拒绝策略：当线程池无法处理新提交的任务时，所采用的策略。
     *      2.线程池的工作原理：
     *             当收到新任务后，若线程池中线程数 < 核心线程数，则会由线程工厂立即创建新的线程执行任务！
     *                          若线程池中线程数 >= 核心线程数，则会判断线程池中有无空闲线程；若有空闲线程，则由空闲线程执行任务
     *                                                                            若无空闲线程，且任务队列未满，将任务放入任务队列中等待执行。
     *                                                                            若无空闲线程，且任务队列已满，则判断线程池中线程数是否达到最大线程数；若未达到，则由线程工厂创建新的线程执行任务。
     *                                                                                                                                    若已达到，则会根据拒绝策略来处理提交的任务。
     * @param model
     */
    //制作本地的代码生成器
    public static void doGenerator(Object model){
        String projectPath = System.getProperty("user.dir");

        //整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();

        //输入路径
        String inputPath = new File(parentFile,"yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        //输出路径
        String outputPath = projectPath;

        //生成静态文件
        StaticGenerator.copyFilesByHutool(inputPath,outputPath);

        //生成动态文件
        String inputDynamicFilePath = projectPath+File.separator+"src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath+File.separator+"acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath,outputDynamicFilePath,model);
    }
    /**
     * 存在弊端：
     *      1.数据模型需要编码提供，如何简化呢？
     *      2.文件路径都写死了！
     *      3.需要main方法来触发代码，才能生成最终结果！
     */
    public static void main(String[] args) {
        //提供数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setOutputText("求和结果：");

        doGenerator(mainTemplateConfig);
    }
}

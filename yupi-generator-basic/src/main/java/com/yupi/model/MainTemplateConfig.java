package com.yupi.model;

import lombok.Data;

/**
 * 动态模板配置
 */
@Data
/**
 * 在Lombok中，@Data注解会为类生成
 *              一个默认的无参构造函数，
 *              以及其他常用的方法如 getter、setter、equals()、hashCode()和toString()等。
 */
public class MainTemplateConfig {
    private boolean loop;//是否生成循环

    /**
     * 需要对下面两个变量设置默认值；因为freemarker对于空值校验非常严格！一旦没有赋值就会报错！
     * 也可以使用freemarker的语法，在模板中设置默认值！
     */

    private String author = "不知名作者";//作者注释

    private String outputText = "sum=";//输出信息
}

package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//作用范围：入口类上 在一个springboot项目中有且只有一个 标记该类为入口类
@SpringBootApplication
@MapperScan("com.baizhi.dao")
//@ComponentScan("com.llf")
public class Application {
    public static void main(String[] args) {
        //启动springboot项目
        //参数1.入口类对象 2.主函数的形参列表
        SpringApplication.run(Application.class,args);
    }
}

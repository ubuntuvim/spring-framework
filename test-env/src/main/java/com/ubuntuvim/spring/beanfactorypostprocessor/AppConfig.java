package com.ubuntuvim.spring.beanfactorypostprocessor;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 声明AppConfig所在的包交给spring容器管理
 * @Author: ubuntuvim
 * @Date: 2020/9/23 下午11:18
 */
@Configuration
@ComponentScan
public class AppConfig {
}

package com.ubuntuvim.spring.beanfactorypostprocessor;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 启动容器
 * @Author: ubuntuvim
 * @Date: 2020/9/23 下午11:19
 */
public class BeanFactoryPostProcessorTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	}
}

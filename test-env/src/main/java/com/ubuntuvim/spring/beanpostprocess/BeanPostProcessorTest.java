package com.ubuntuvim.spring.beanpostprocess;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/24 下午10:29
 */
public class BeanPostProcessorTest {
	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(AppConfig.class);
	}
}

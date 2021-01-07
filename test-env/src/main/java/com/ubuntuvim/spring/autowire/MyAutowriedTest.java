package com.ubuntuvim.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用AutowiredAnnotationBeanPostProcessor的特性，自定义一个注解交给它处理
 */
public class MyAutowriedTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		Person person = applicationContext.getBean(Person.class);
		person.test();
	}
}

package com.ubuntuvim.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ubuntuvim;
 * @Date: 2020/9/14 下午11:41
 */
public class MyClassPathXmlApplicationContextTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:/spring-env-test.xml");
		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
		System.out.println(testBean);
	}
}

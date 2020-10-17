package com.ubuntuvim.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/13 下午5:13
 */
public class MyFileSystemXmlApplicationContextTest {
	public static void main(String[] args) {
		ApplicationContext ac = new FileSystemXmlApplicationContext("//Users/ubuntuvim/code/spring-framework/test-env/src/main/resources/spring-env-test.xml");
		System.out.println(ac.getBean("testBean"));
	}
}

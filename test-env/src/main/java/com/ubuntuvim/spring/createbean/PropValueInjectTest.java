package com.ubuntuvim.spring.createbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ubuntuvim
 * @Date: 2020/10/18 上午1:01
 */
public class PropValueInjectTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prop-inject-test.xml");

	}
}

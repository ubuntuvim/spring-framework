package com.ubuntuvim.spring.scop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		UsePrototypeServiceBean usePrototypeServiceBean = applicationContext.getBean(UsePrototypeServiceBean.class);
		for (int i = 0 ; i < 10; i++) {
			System.out.println(usePrototypeServiceBean.test());
		}
	}
}


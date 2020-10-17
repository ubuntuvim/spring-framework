package com.ubuntuvim.spring;


import com.ubuntuvim.spring.config.AnnotationConfigApplicationContextConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/14 下午10:53
 */
public class MyAnnotationConfigApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfigApplicationContextConfig.class);
//		ParentConfigService parentConfigService = applicationContext.getBean(ParentConfigService.class);
//		System.out.println(parentConfigService);
	}

}

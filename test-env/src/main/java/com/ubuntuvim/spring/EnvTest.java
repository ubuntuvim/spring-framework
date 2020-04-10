package com.ubuntuvim.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试环境是否正确配置
 */
public class EnvTest {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-env-test.xml");
		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
		testBean.setName("ubuntuvim");
		System.out.println(testBean);
//		System.out.println("\n\n\n" + System.getenv() + "\n\n\n");
//		System.out.println("\n\n\n" + System.getProperties() + "\n\n\n");

		ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext(AppConfig.class);
		ConfigBean configBean = applicationContext2.getBean(ConfigBean.class);
		System.out.println(configBean);

	}

}

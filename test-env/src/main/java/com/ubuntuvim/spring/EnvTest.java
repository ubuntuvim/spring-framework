package com.ubuntuvim.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * 测试环境是否正确配置
 */
public class EnvTest {
	public static void main(String[] args) {

//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-env-test.xml");
//		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
//		testBean.setName("ubuntuvim");
//		System.out.println(testBean);
//		System.out.println("\n\n\n" + System.getenv() + "\n\n\n");
//		System.out.println("\n\n\n" + System.getProperties() + "\n\n\n");

		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("容器实例：" + applicationContext);
//		ConfigBean configBean = applicationContext.getBean(ConfigBean.class);
//		System.out.println(configBean);
//		configBean.start();
//		configBean.stop();
//
//		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
//		System.out.println(testBean);

		// 获取上下文实例
		MyApplicationContextAware myApplicationContextAware = (MyApplicationContextAware) applicationContext.getBean("myApplicationContextAware");
		System.out.println(myApplicationContextAware.getApplicationContext());
		// 获取到实例对象应该就是前面创建的applicationContext，
		System.out.println(applicationContext == myApplicationContextAware.getApplicationContext());

		// 事件监听测试，通过publisher发送事件，通过listener接收事件
		MyApplicationEventPublisherAware myApplicationEventPublisherAware = applicationContext.getBean(MyApplicationEventPublisherAware.class);
		myApplicationEventPublisherAware.sendMsg();

		// 关闭容器时配置在bean上的销毁方法就会被执行
		applicationContext.close();
	}


}

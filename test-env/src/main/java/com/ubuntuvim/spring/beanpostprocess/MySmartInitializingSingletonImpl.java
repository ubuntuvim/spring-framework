package com.ubuntuvim.spring.beanpostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 在所有bean实例化之后（初始化前）回调这个接口afterSingletonsInstantiated
 * 初始化操作执行顺序：@PostConstruct是最先被执行的，然后是InitializingBean，最后是SmartInitializingSingleton
 */
@Component
public class MySmartInitializingSingletonImpl implements SmartInitializingSingleton, ApplicationContextAware, InitializingBean {

	ApplicationContext applicationContext;

	@PostConstruct
	public void invokePostConstruct() {
		System.out.println("1. @PostConstruct注释方法被执行");
	}

	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("3. SmartInitializingSingleton接口的afterSingletonsInstantiated()方法被执行了");
		InitBean initBean = applicationContext.getBean(InitBean.class);
		initBean.f();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("2. InitializingBean接口的afterPropertiesSet()方法被执行了");
	}
}

package com.ubuntuvim.spring.createbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/10/18 上午1:41
 */
//@Component
public class MyBeanPostProcessorImpl implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if ("InitCallbackBean".equalsIgnoreCase(beanName))
			System.out.println("执行初始化回调BeanPostProcessor.postProcessBeforeInitialization()方法");

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("InitCallbackBean".equalsIgnoreCase(beanName))
			System.out.println("执行初始化回调BeanPostProcessor.postProcessAfterInitialization()方法");

		return bean;
	}
}

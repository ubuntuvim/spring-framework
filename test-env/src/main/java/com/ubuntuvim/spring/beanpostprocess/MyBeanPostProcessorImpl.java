package com.ubuntuvim.spring.beanpostprocess;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/24 下午10:31
 */
@Component
@Lazy
public class MyBeanPostProcessorImpl implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "\t执行postProcessBeforeInitialization()方法");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(beanName + "\t执行postProcessAfterInitialization()方法");
		return bean;
	}
}

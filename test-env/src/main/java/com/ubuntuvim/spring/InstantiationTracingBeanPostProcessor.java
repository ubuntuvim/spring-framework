package com.ubuntuvim.spring;/**
 * @Author: ubuntuvim
 * @Date: 2020/5/16 18:16
 */

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/16 18:16
 */
@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("bean初始化前 postProcessBeforeInitialization + " + bean + ", beanName = " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean初始化之后 '" + beanName + "' created : " + bean.toString());
		return bean;
	}
}

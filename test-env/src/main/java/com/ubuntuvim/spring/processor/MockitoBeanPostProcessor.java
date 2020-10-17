package com.ubuntuvim.spring.processor;


import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/20 23:16
 */
//@Component
public class MockitoBeanPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Map<Class<?>, MockitoBeansTestExecutionListener.MockBeanWrapper> allMockBeans = MockitoBeansTestExecutionListener.resolvedAllMockBeans();
		for (Map.Entry<Class<?>, MockitoBeansTestExecutionListener.MockBeanWrapper> mockBeanWrapperEntry : allMockBeans.entrySet()) {
			beanFactory.registerResolvableDependency(mockBeanWrapperEntry.getKey(), mockBeanWrapperEntry.getValue().getMockObject());
		}
	}
}

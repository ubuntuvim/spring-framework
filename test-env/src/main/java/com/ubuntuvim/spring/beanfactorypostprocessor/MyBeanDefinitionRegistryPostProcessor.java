package com.ubuntuvim.spring.beanfactorypostprocessor;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 通过编程方式注册InjectBeanFromPostProcessor
 * 同样的本类设置成懒加载也是无效的
 * @Author: ubuntuvim
 * @Date: 2020/7/17 20:43
 */
@Component
@Lazy
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	public MyBeanDefinitionRegistryPostProcessor() {
		System.out.println("\n" + this.getClass().getName() + "被加载了。。。\n");
	}
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		//编程方式注入一个bean定义
		registry.registerBeanDefinition(InjectBeanFromPostProcessor.class.getName(),
				new RootBeanDefinition(InjectBeanFromPostProcessor.class));
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// 本方法的功能和BeanFactoryPostProcessor一样。本来就是从BeanFactoryPostProcessor继承过来的。
	}
}

package com.ubuntuvim.mock.processor;


import java.util.ArrayList;
import java.util.List;

import com.ubuntuvim.mock.bean.ServiceImplA;
import com.ubuntuvim.mock.bean.ServiceImplBDependecyA;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/23 01:15
 */
@Component
public class MockitoBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	static List<Class<?>> clazzList = new ArrayList<>();
	static {
		clazzList.add(ServiceImplA.class);
		clazzList.add(ServiceImplBDependecyA.class);
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// 把实例化耗时的bean手动注入到容器中，但是要在启动类中先把这些类排除掉，以防止Spring容器自动实例化。
//		ServiceImplA.class,
//				ServiceImplBDependecyA.class

//		for (Class<?> clazz : clazzList) {
//			System.out.println("\n\n开始注入Mock对象: " + clazz);
//			Object mockObject = Mockito.mock(clazz);
//			System.out.println("\n\nMock对象mockObject: " + mockObject);
//			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(mockObject.toString());
			Class<?> serviceAClass = (new ServiceImplA()).getClass();
		System.out.println("serviceAClass.getSimpleName() = " + serviceAClass.getSimpleName());
			BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(serviceAClass);
			GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
			//这里采用的是byType方式注入，类似的还有byName等
			definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
			registry.registerBeanDefinition(serviceAClass.getSimpleName(), definition);

//		}

		//在这里，我们可以给该对象的属性注入对应的实例。
		//比如mybatis，就在这里注入了dataSource和sqlSessionFactory，
		// 注意，如果采用definition.getPropertyValues()方式的话，
		// 类似definition.getPropertyValues().add("interfaceType", beanClazz);
		// 则要求在FactoryBean（本应用中即ServiceFactory）提供setter方法，否则会注入失败
		// 如果采用definition.getConstructorArgumentValues()，
		// 则FactoryBean中需要提供包含该属性的构造方法，否则会注入失败
//		definition.getConstructorArgumentValues().addGenericArgumentValue(beanClazz);

		//注意，这里的BeanClass是生成Bean实例的工厂，不是Bean本身。
		// FactoryBean是一种特殊的Bean，其返回的对象不是指定类的一个实例，
		// 其返回的是该工厂Bean的getObject方法所返回的对象。
//		definition.setBeanClass(ServiceFactory.class);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}

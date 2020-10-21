package com.ubuntuvim.spring.createbean;

import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * 验证Spring创建bean的方法。
 * 对于的源码是：
 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#createBeanInstance(String, RootBeanDefinition, Object[])
 * 1. 通过Supplier的get（）方法创建
 * 2。 通过工厂方法创建
 * 3。 通过构造方法创建
 * @Author: ubuntuvim
 * @Date: 2020/10/17 下午4:48
 */
public class CreateBeanTest {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
//		Person person = applicationContext.getBean(Person.class);
//		person.eat();
		// 执行各种销毁回调
		applicationContext.close();
	}
}

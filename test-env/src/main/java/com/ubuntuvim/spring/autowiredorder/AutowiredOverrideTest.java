package com.ubuntuvim.spring.autowiredorder;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredOverrideTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		Person person = applicationContext.getBean(Person.class);
		/**
		 * 运行结果：
		 * 香蕉是可以吃的水果
		 * 说明同样的属性，先执行了注解方式的注入，然后再执行xml方式的注入。
		 * 源码位置，
		 * @see org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#populateBean(String, RootBeanDefinition, BeanWrapper)
		 * 从这个方法的源码就可以看到，先执行了注解方式的注入，最后一行才是xml配置方式注入。
		 */
		person.eatFruit();
	}
}

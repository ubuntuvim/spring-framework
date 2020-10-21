package com.ubuntuvim.spring.createbean;

import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

/**
 * Spring创建实例时会通过有参构造方法创建实例，
 * 并且会自动先实例化依赖的RefrenceBeanA。
 * 代码位置：
 * @see AbstractAutowireCapableBeanFactory#createBeanInstance(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, java.lang.Object[])
 * 再调用，有参构造方法实例化bean，构造方法不需要使用@Autowired注解声明
 * @see AbstractAutowireCapableBeanFactory#autowireConstructor(java.lang.String, org.springframework.beans.factory.support.RootBeanDefinition, java.lang.reflect.Constructor[], java.lang.Object[])
 * @Author: ubuntuvim
 * @Date: 2020/10/17 下午5:26
 */
//@Component
public class HasArgsConstructBean {
	private RefrenceBeanA refrenceBeanA;

	public HasArgsConstructBean(RefrenceBeanA refrenceBeanA) {
		this.refrenceBeanA = refrenceBeanA;
	}
}

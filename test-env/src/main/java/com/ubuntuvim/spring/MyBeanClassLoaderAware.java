package com.ubuntuvim.spring;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

/**
 * Bean实例化之后，Spring自动把类加载器注入到实现类中
 * @Author: ubuntuvim
 * @Date: 2020/5/16 16:56
 */
@Component
public class MyBeanClassLoaderAware implements BeanClassLoaderAware {
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("通过BeanClassLoaderAware获取加载当前类的类加载器：" + classLoader);
	}
}

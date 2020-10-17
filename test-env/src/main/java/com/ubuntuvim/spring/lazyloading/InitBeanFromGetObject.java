package com.ubuntuvim.spring.lazyloading;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/7/18 02:28
 */
@Component
public class InitBeanFromGetObject implements FactoryBean<InitBeanFromGetObject2> {
	@Override
	public InitBeanFromGetObject2 getObject() throws Exception {
		System.out.println(this.getClass().getName() + "被调用");
		return new InitBeanFromGetObject2();
	}

	@Override
	public Class<?> getObjectType() {
		return InitBeanFromGetObject2.class;
	}
}

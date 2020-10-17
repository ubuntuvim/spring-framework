package com.ubuntuvim.spring;/**
 * @Author: ubuntuvim
 * @Date: 2020/5/6 01:56
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *  ApplicationContextAware 接口用于注入一个ApplicationContext实例，
 *  当所有的bean被初始化之后就会自动把上下文注入到ApplicationContext实现类中。
 *
 * @Author: ubuntuvim
 * @Date: 2020/5/6 01:56
 */
@Component
public class MyApplicationContextAware implements ApplicationContextAware {

	ApplicationContext applicationContext ;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("所有bean被初始化之后把上下文注入到此类中。" + applicationContext);
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return this.applicationContext;
	}
}

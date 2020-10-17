package com.ubuntuvim.spring.lazyloading;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/7/17 21:26
 */
@Component
@Lazy
public class MyInitializingBean implements InitializingBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("实现了InitializingBean的afterPropertiesSet()方法被调用了");
	}
}

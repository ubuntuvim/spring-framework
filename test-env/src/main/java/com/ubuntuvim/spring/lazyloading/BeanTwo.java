package com.ubuntuvim.spring.lazyloading;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ubuntuvim
 * @Date: 2020/7/17 20:47
 */
@Component
@Lazy
public class BeanTwo {
	public BeanTwo() {
		System.out.printf("开始加载BeanTwo");
	}

	@Resource
	@Lazy
	BeanOne beanOne;

	public void invokeBeanOneMethod() {
		System.out.println("在BeanTwo里面调用BeanOne的方法");
		beanOne.sayHelloBeanOne();
	}
}

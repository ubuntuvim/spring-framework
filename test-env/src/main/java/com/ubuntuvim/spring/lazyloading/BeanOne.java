package com.ubuntuvim.spring.lazyloading;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/7/17 20:46
 */
@Component
@Lazy
public class BeanOne {
	public BeanOne() {
		System.out.println("beanFactory开始加载BeanOne");
	}

	public void sayHelloBeanOne() {
		System.out.println("调用BeanOne的方法");
	}
}

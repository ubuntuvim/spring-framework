package com.ubuntuvim.spring.lazyloading;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ubuntuvim
 * @Date: 2020/7/17 23:00
 */
@Component
public class BeanRef {

	public BeanRef() {
		System.out.println("BeanRef被加载了"+this.getClass().getClassLoader());
	}

	@Resource
	@Lazy
	MyInitializingBeanNoLazy myInitializingBeanSubClassUseLazyByOtherRef;

	public void useProp() {
		System.out.println("开始使用属性myInitializingBeanSubClassUseLazyByOtherRef");
		myInitializingBeanSubClassUseLazyByOtherRef.getName();
		System.out.println("使用属性并调用其方法完毕");
	}
}

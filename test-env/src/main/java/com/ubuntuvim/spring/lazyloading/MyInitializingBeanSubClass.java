package com.ubuntuvim.spring.lazyloading;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 本类使用了延迟加载注解，并不能对父类的加载起作用
 *
 * @Author: ubuntuvim
 * @Date: 2020/7/17 21:35
 */
@Component
@Lazy
public class MyInitializingBeanSubClass extends MyInitializingBeanNoLazy {
	public MyInitializingBeanSubClass() {
		System.out.println(this.getClass().getName() + "的子类使用@Lazy注解，子类被加载了");
	}
}

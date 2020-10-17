package com.ubuntuvim.spring.beanpostprocess;


import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/24 下午10:28
 */
@Component
public class BeanA {

	public BeanA() {
		System.out.println("\n" + this.getClass().getName() + "构造方法被加执行了。。。\n");
	}

	int a = f();

	private int f() {
		System.out.println(this.getClass().getName() + "被初始化了。");
		return 100;
	}
}

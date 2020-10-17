package com.ubuntuvim.spring.beanpostprocess;

import org.springframework.stereotype.Component;

/**
 * 所有bean实例化完成之后调用这个类的方法，
 * @Author: ubuntuvim
 * @Date: 2020/10/9 上午12:54
 */
@Component
public class InitBean {
	public void f() {
		System.out.println(this.getClass().getName().concat("的方法f()被调用"));
	}
}

package com.ubuntuvim.spring.lazyloading;


/**
 * @Author: ubuntuvim
 * @Date: 2020/7/18 02:29
 */
public class InitBeanFromGetObject2 {
	public InitBeanFromGetObject2() {
		System.out.println(this.getClass().getName() + "被创建");
	}
}

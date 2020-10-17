package com.ubuntuvim.spring.config;


/**
 * @Author: ubuntuvim
 * @Date: 2020/9/19 上午12:00
 */
public class InnerConfiguration {
	public InnerConfiguration() {
		System.out.println(this.getClass().getName() + "被加载了。。。");
	}
}

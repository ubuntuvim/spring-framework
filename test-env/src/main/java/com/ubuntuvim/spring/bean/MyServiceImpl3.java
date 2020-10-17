package com.ubuntuvim.spring.bean;


/**
 * @Author: ubuntuvim
 * @Date: 2020/5/17 00:23
 */
public class MyServiceImpl3 implements MyService {
	public void test() {
		System.out.println("这是一个通过@Bean注解声明的类。");
	}

	@Override
	public String msg(String tip) {
		return "MyServiceImpl2".concat(tip);
	}

	@Override
	public void hello() {
		System.out.println("这个MyServiceImpl3的hello方法。");
	}
}

package com.ubuntuvim.spring.bean;


/**
 * @Author: ubuntuvim
 * @Date: 2020/5/17 00:23
 */
public class MyServiceImpl implements MyService {

	private MyServiceCommonImpl myServiceCommonImpl;

	public MyServiceCommonImpl getMyServiceCommonImpl() {
		return myServiceCommonImpl;
	}

	public void setMyServiceCommonImpl(MyServiceCommonImpl myServiceCommonImpl) {
		this.myServiceCommonImpl = myServiceCommonImpl;
	}

	public void test() {
		System.out.println("这是一个通过@Bean注解声明的类。");
	}

	@Override
	public String msg(String tip) {
		return null;
	}

	@Override
	public void hello() {
		System.out.println("这个是MyServiceImpl的hello方法。");
	}
}

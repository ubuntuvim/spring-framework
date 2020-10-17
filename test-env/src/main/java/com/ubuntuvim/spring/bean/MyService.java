package com.ubuntuvim.spring.bean;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/17 01:48
 */
public interface MyService {
	/**
	 * 返回"你好"+tip
	 * @param tip
	 */
	String msg(String tip);

	void hello();
}

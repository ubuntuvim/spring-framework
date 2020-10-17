package com.ubuntuvim.spring.lazyloading;


/**
 * @Author: ubuntuvim
 * @Date: 2020/7/18 02:15
 */
public class InitFromGetObjectMethodBean {
	public InitFromGetObjectMethodBean() {
		System.out.println("\n\n" + this.getClass().getName() + "这个bean是通过FactoryBean.getObject方法创建的\n\n");
	}
}

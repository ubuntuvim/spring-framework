package com.ubuntuvim.mock.bean;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/22 22:59
 */
@Component
public class ServiceImplCDependecyB {
	@Resource
	ServiceImplBDependecyA serviceImplBDependecyA;

	public String msg(String tip) {
		System.out.println("ServiceImplCDependecyB,"+tip);
		System.out.println("====================");
		serviceImplBDependecyA.msg(tip);
		return "ServiceImplCDependecyB hello,".concat(tip);
	}
}

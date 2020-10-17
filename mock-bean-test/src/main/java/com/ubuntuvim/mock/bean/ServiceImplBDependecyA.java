package com.ubuntuvim.mock.bean;


import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/22 22:59
 */
@Component
@Log
public class ServiceImplBDependecyA {
	public ServiceImplBDependecyA() {
		System.out.println("\n\nServiceImplA被实例化了\n\n");
	}

	@Resource
	ServiceImplA serviceImplA;

	public String msg(String tip) {
		System.out.println("ServiceImplBDependecyA,"+tip);
		System.out.println("====================");
		serviceImplA.msg(tip);
		return "ServiceImplBDependecyA,hello,".concat(tip);
	}
}

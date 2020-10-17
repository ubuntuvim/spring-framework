package com.ubuntuvim.mock.bean;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/22 22:58
 */
@Component
@Log
public class ServiceImplA {

	@PostConstruct
	public void init() {
		System.out.println("\n\nServiceImplA的PostConstruct,init方法\n\n");
	}

	public ServiceImplA() {
		System.out.println("\n\nServiceImplA被实例化了\n\n");
	}
	public String msg(String tip) {
		System.out.println("ServiceImplA," + tip);
		return "ServiceImplA,hello,".concat(tip);
	}
}

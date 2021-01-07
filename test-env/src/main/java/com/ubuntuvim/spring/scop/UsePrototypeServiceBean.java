package com.ubuntuvim.spring.scop;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UsePrototypeServiceBean {
	// 引用一个prototype类型的bean，
	@Resource
	PrototypeServiceImpl prototypeService;

	// 验证每次获取到的是否也是单例的实例
	public PrototypeServiceImpl test() {
		return this.prototypeService;
	}
}

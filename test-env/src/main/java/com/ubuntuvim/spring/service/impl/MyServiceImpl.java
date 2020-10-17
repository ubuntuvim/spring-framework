package com.ubuntuvim.spring.service.impl;


import com.ubuntuvim.spring.bean.MyService;
import com.ubuntuvim.spring.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/20 23:04
 */
@Component
public class MyServiceImpl implements MyService {
	@Resource
	UserService userServiceImpl;

	@Override
	public void hello() {
		userServiceImpl.printUser();
	}

	@Override
	public String msg(String msg) {
		return "你好"+msg;
	}
}

package com.ubuntuvim.spring.service.impl;


import com.ubuntuvim.spring.service.UserService;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/20 23:46
 */
@Component
public class UserServiceImpl implements UserService {

	@Override
	public String getName() {
		return "ubuntuvim";
	}

	@Override
	public void printUser() {
		System.out.println("hello " + this.username);
	}
	String username;
	public void setUserName(String username) {
		this.username = username;
	}
}

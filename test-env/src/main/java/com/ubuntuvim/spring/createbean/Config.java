package com.ubuntuvim.spring.createbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ubuntuvim
 * @Date: 2020/10/17 下午4:46
 */
@ComponentScan
@Configuration
public class Config {
//	@Bean(initMethod = "beanInit")
//	public InitCallbackBean initCallbackBean() {
//		return new InitCallbackBean();
//	}

	@Bean(destroyMethod = "beanDestoryCallbackMethod")
	public DestoryCallbackBean destoryCallbackBean() {
		return new DestoryCallbackBean();
	}
}

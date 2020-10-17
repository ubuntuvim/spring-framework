package com.ubuntuvim.spring.config;


import com.ubuntuvim.spring.bean.ParentConfigService;

import org.springframework.context.annotation.Bean;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/21 下午11:06
 */
public class AnnotationConfigApplicationContextConfigParent {
	@Bean
	public ParentConfigService parentConfigService() {
		return new ParentConfigService();
	}
}

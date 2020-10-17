package com.ubuntuvim.spring.msg;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/26 上午12:37
 */
@Configuration
@ComponentScan
public class AppConfig {
	/**
	 * 定义messageSource，并交给容器管理，容器在启动的时候就会执行到
	 * AbstractApplicationContext.refresh() -> initMessageSource()方法
 	 */
	@Bean
	public MessageSource messageSource() {
		/*
		这个接口有三个实现类：
		1. ResourceBundleMessageSource：
		2. ReloadableResourceBundleMessageSource：
		3. StaticMessageSource：
		 */
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		// 一定要设置配置文件的名称前缀，我定义的properties文件的都是以msgSource开头的
		messageSource.setBasename("msgSource");
		return messageSource;
	}
}

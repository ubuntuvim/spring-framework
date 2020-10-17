package com.ubuntuvim.spring.msg;


import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/26 上午12:46
 */
public class MsgSourceTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		MessageSource messageSource = (MessageSource) applicationContext.getBean(AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME);
		// 指定获取中文环境下的值
		String message = messageSource.getMessage("test.key", null, Locale.CHINESE);
		System.out.println(message);

		// 指定获取英文环境下的值
		String message2 = messageSource.getMessage("test.key", null, Locale.ENGLISH);
		System.out.println(message2);

		// 指定获取默认值getDefault会自动根据系统环境判断使用那个环境的配置文件
		String message3 = messageSource.getMessage("test.key", null, Locale.getDefault());
		System.out.println(message3);

		// 如果找不到匹配的语言环境配置文件则使用msgSource.properties的配置
		String message4 = messageSource.getMessage("test.key", null, null);
		System.out.println(message4);


	}
}

package com.ubuntuvim.spring.event;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/26 上午2:05
 */
public class EventTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		// 发布事件
		applicationContext.publishEvent(new MyEvent(new EventContent("中国的原子弹搞出来了。")));
	}
}

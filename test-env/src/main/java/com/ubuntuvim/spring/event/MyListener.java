package com.ubuntuvim.spring.event;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 定义一个事件监听器。
 * Spring4.1之后有两种实现监听器：
 * 1. 实现ApplicationListener接口
 * 2. 使用@EventListener注解
 * @Author: ubuntuvim
 * @Date: 2020/9/26 上午2:02
 */
@Component
public class MyListener implements ApplicationListener<MyEvent> {
	@Override
	public void onApplicationEvent(MyEvent event) {
		System.out.println(this.getClass().getName() + "监听到了发布的事件，事件内容是: " + event.getSource());
	}

	@EventListener
	public void listenerEvent(MyEvent myEvent) {
		System.out.println("使用@EventListener方式，监听到了发布的事件，事件内容是: " + myEvent.getSource());
	}
}

package com.ubuntuvim.spring;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/17 02:29
 */
@Component
public class MyApplicationListener implements ApplicationListener<com.ubuntuvim.spring.MyApplicationEvent> {

	/**
	 * 只要有调用MyApplicationEventPublisherAware.sendMsg()方法，这里就会自动接收到消息，
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(com.ubuntuvim.spring.MyApplicationEvent event) {
		System.out.println("ApplicationListener 接收到事件： " + ((Msg)event.getSource()).getContent());
	}
}

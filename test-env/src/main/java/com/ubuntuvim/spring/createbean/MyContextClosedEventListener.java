package com.ubuntuvim.spring.createbean;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyContextClosedEventListener {

	@EventListener
	public void iocCloseEvent(ContextClosedEvent contextClosedEvent) {
		System.out.println("收到容器关闭的消息： " + contextClosedEvent);
	}

}

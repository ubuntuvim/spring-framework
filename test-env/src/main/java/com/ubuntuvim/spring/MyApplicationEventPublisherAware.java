package com.ubuntuvim.spring;


import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/17 02:24
 */
@Component
public class MyApplicationEventPublisherAware implements ApplicationEventPublisherAware {

	ApplicationEventPublisher applicationEventPublisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	@Resource
	Msg msg;

	public void sendMsg() {
		System.out.println("发送某些东西");
		msg.setContent("消息内容。。。");
		applicationEventPublisher.publishEvent(new MyApplicationEvent(msg));
	}
}

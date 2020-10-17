package com.ubuntuvim.spring;


import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/17 02:31
 */
@SuppressWarnings("serial")
@Component
public class MyApplicationEvent extends ApplicationEvent {
	public MyApplicationEvent(Msg msg) {
		super(msg);
	}
}

package com.ubuntuvim.spring.event;


import org.springframework.context.ApplicationEvent;

/**
 * 定义一个事件
 * @Author: ubuntuvim
 * @Date: 2020/9/26 上午1:55
 */
public class MyEvent extends ApplicationEvent {

	private static final long serialVersionUID = 21162432L;

	/**
	 * 事件的内容必须是实现Serializable接口的
	 * @param source
	 */
	public MyEvent(EventContent source) {
		super(source);
	}
}

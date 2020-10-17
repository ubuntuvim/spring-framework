package com.ubuntuvim.spring.event;


import java.io.Serializable;
import java.util.Date;

/**
 * 事件内容，必须实现Serializable接口
 * @Author: ubuntuvim
 * @Date: 2020/9/26 上午2:08
 */
public class EventContent implements Serializable {

	private static final long serialVersionUID = 2432432L;

	private String content;

	public EventContent(String content) {
		this.content = content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "EventContent{" +
				"content='" + content + '\'' +
				'}';
	}
}

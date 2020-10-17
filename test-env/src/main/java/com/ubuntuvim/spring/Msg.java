package com.ubuntuvim.spring;


import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/17 02:49
 */
@Component
public class Msg {
	String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}

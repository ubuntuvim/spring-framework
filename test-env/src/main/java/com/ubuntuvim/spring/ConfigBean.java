package com.ubuntuvim.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigBean {

	@Value("${username:张三}")
	String name;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ConfigBean{");
		sb.append("name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}
}

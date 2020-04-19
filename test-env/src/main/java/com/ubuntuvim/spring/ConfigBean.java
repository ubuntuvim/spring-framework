package com.ubuntuvim.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 *
 */
@Component
public class ConfigBean implements Lifecycle {

	@Value("${username:张三}")
	String name;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("ConfigBean{");
		sb.append("name='").append(name).append('\'');
		sb.append('}');
		return sb.toString();
	}

	@Override
	public void start() {
		System.out.println("bean start....");
	}

	@Override
	public void stop() {
		System.out.println("bean stop....");
	}

	@Override
	public boolean isRunning() {
		return true;
	}


}

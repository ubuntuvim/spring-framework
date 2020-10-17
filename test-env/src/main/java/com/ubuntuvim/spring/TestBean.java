package com.ubuntuvim.spring;

import org.springframework.stereotype.Component;

@Component
public class TestBean {
	String name;
	String address;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("TestBean{");
		sb.append("name='").append(this.name).append('\'');
		sb.append(", address='").append(this.address).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

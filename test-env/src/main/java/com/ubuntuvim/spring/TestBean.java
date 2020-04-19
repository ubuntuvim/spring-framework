package com.ubuntuvim.spring;

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
}

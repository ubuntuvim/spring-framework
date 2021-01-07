package com.ubuntuvim.spring.autowire;

public class Orange implements Fruit {
	@Override
	public void eatable() {
		System.out.println("橙子也是可以吃的水果");
	}
}

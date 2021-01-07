package com.ubuntuvim.spring.autowiredorder;

public class Apple implements Fruit {
	@Override
	public void eatable() {
		System.out.println("苹果是可以吃的水果");
	}
}
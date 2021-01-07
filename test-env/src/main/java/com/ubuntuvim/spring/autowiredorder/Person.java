package com.ubuntuvim.spring.autowiredorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

	private Fruit fruit;

	public void eatFruit() {
		fruit.eatable();
	}

	public Fruit getFruit() {
		return fruit;
	}

	@Autowired
	// 指定注入的是Apple这个实例
	@Qualifier("apple")
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
}

package com.ubuntuvim.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Person {

	@MyAutowired
	private Fruit apple;

	@MyAutowired
	@Lazy
	private Fruit banana;

	// 验证AutowiredAnnotationBeanPostProcessor原来的注解是否能起效果
	@Autowired
	private Fruit orange;

	private List<Fruit> fruits = new ArrayList<>();

	public void test() {
		System.out.println(apple);
		System.out.println(banana);
		// 验证列表是否能注入
		fruits.stream().forEach(Fruit::eatable);
	}

	public List<Fruit> getFruits() {
		return fruits;
	}

	@MyAutowired
	public void setFruits(List<Fruit> fruits) {
		this.fruits = fruits;
	}
}

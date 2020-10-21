package com.ubuntuvim.spring.createbean;

import com.ubuntuvim.spring.createbean.impl.Apple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ubuntuvim
 * @Date: 2020/10/17 下午11:04
 */
@Component
public class Person {

	private String name;

	private Apple apple;

	@Autowired
	private List<Fruit> fruitList;

	@Autowired
	private Map<String, Fruit> fruitMap;

	public void eat() {
		fruitList.stream().forEach((f) -> {
			f.eatable();
		});
		System.out.println("\n\n ===== Map ===== \n\n");
		Set<Map.Entry<String, Fruit>> entries = fruitMap.entrySet();
		for (Map.Entry<String, Fruit> entry : entries) {
			entry.getValue().eatable();
		}
	}
}

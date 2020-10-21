package com.ubuntuvim.spring.createbean.impl;

import com.ubuntuvim.spring.createbean.Fruit;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/10/17 下午11:00
 */
@Component
public class Apple implements Fruit {
	@Override
	public void eatable() {
		System.out.println("苹果是可以吃的水果。");
	}
}

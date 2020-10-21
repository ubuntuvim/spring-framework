package com.ubuntuvim.spring.createbean;

import org.springframework.stereotype.Component;

import java.io.Closeable;

/**
 * 当前bean既不实现DispoableBean接口，也没有自定义的销毁方法
 * 但是有一个AutoCloseable.close()方法，验证容器关闭时是否会回调AutoCloseable.close()方法。
 * 实现Closeable接口也是同样的效果。
 * @Author: ubuntuvim
 * @Date: 2020/10/18 下午10:38
 */
@Component
public class SimpleDestoryBean implements Closeable {

	@Override
	public void close() {
		System.out.println("既不实现DispoableBean接口，也没有自定义的销毁方法的情况下执行最后默认的AutoCloseable.close方法");
	}
}

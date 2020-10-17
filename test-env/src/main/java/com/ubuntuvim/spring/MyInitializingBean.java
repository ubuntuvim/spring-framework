package com.ubuntuvim.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * bean生命周期回调方法测试，afterPropertiesSet方法会在每个bean实例化并设置了所有必需的属性后调用,
 * 还有另外一种不依赖于Spring框架的方式也可以实现bean属性设置完成之后调用某个方法，使用jdk的@PostConstruct注解，
 * 注意：这两种方式执行的顺序是先执行@PostConstruct注解方法再执行afterPropertiesSet方法
 * @Author: ubuntuvim
 * @Date: 2020/5/6 00:56
 */
@Component
public class MyInitializingBean implements InitializingBean {

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("\n\n执行afterPropertiesSet方法\n\n");
	}

	/**
	 * @PostConstruct是jdk的注解，不需要依赖于Spring，减少代码侵入
	 */
	@PostConstruct
	public void afterPropertiesSetNotDependencySpring() {
		System.out.println("\n\n执行afterPropertiesSetNotDependencySpring方法\n\n");
	}
}

package com.ubuntuvim.spring.lazyloading;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: ubuntuvim
 * @Date: 2020/7/17 20:53
 */
public class LazyLoadingTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(BeanLoadingConfig.class);
		BeanTwo beanTwo = (BeanTwo) ac.getBean("beanTwo");
		// 未调beanTwo 的方法之后，不应该加载BeanOne。
		System.out.println("未调beanTwo 的方法之后，不应该加载BeanOne（但事与愿违）");
		beanTwo.invokeBeanOneMethod();
		/*
		执行结果：
			开始加载BeanTwo

			beanFactory开始加载BeanOne  ---- 因为BeanTwo里面引用了BeanOne，所以BeanOne在BeanTwo加载的时候也被加载了，不然无法初始化属性。
			未调beanTwo 的方法之后，不应该加载BeanOne
			在BeanTwo里面调用BeanOne的方法
		 */

		// 只使用BeanOne时，BeanTwo不会被加载
		BeanOne beanOne = (BeanOne) ac.getBean("beanOne");
		/*
		执行结果：
			beanFactory开始加载BeanOne
		 */

		// 在未使用MyInitializingBean之前，如果bean使用了@Lazy注解，即使这个bean实现了InitializingBean的接口也不会被加载
		System.out.println("在未使用MyInitializingBean之前，如果bean使用了@Lazy注解，即使这个bean实现了InitializingBean的接口也不会被加载");
		MyInitializingBean myInitializingBean = (MyInitializingBean) ac.getBean("myInitializingBean");
		/*
		由于显示调用了这个Bean，所以被加载了
		结果：
		实现了InitializingBean的afterPropertiesSet()方法被调用了
		 */
	}
}

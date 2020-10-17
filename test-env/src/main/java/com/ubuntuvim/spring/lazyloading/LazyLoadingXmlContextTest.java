package com.ubuntuvim.spring.lazyloading;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: ubuntuvim
 * @Date: 2020/7/17 22:03
 */
public class LazyLoadingXmlContextTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:lazy-loading-test.xml");
		// 容器加载，MyInitializingBeanSubClassUseLazy和MyInitializingBeanSubClassNotUseLazy都交给容器管理。
		/*
		执行结果可见，afterPropertiesSet()方法被调用了。
		MyInitializingBeanNoLazy被加载了，name =
		===== MyInitializingBeanNoLazy的afterPropertiesSet()方法被调用了 =====
		name的值是：未使用lazy-init=true
		*/
//		MyInitializingBeanNoLazy myInitializingBeanNoLazy = (MyInitializingBeanNoLazy) ac.getBean("myInitializingBeanSubClassUseLazy");
//		System.out.println(myInitializingBeanNoLazy instanceof MyInitializingBeanNoLazy);

		// 即使没用使用BeanRef，但是由于在类中引用了myInitializingBeanSubClassUseLazyByOtherRef，
		// 即使myInitializingBeanSubClassUseLazyByOtherRef定义成lazy-init=true也会被加载。
		BeanRef beanRef = (BeanRef) ac.getBean("beanRef");
		// 在没用使用到myInitializingBeanSubClassUseLazyByOtherRef属性之前，不会加载这个属性类。
		System.out.println("\n没有使用到BeanRef中引用的属性，属性类不会被加载\n");
		// 使用myInitializingBeanSubClassUseLazyByOtherRef
		beanRef.useProp();
		/*
		执行结果：
		开始使用属性myInitializingBeanSubClassUseLazyByOtherRef
		MyInitializingBeanNoLazy被加载了sun.misc.Launcher$AppClassLoader@2a139a55    --> 属性类被加载
		===== MyInitializingBeanNoLazy的afterPropertiesSet()方法被调用了 =====        --> 属性类的初始化方法被调用
		name的值是：使用了Lazy-init=true，但是被另外的类引用了。也会被加载。					--> BeanRef本身被加载
		使用属性并调用其方法完毕														--> 调用BeanRef方法，触发加载
		 */
		System.out.println("\n在未使用InitFromGetObjectMethodBean之前，这个InitFromGetObjectMethodBean类不会在容器启动的时候实例化");
		// 在没有使用过bean之前，通过FactoryBean.getObject创建的bean不会直接在容器启动的时候实例化。比如InitBeanFromGetObject2不会在容器启动的时候实例化。
		InitFromGetObjectMethodBean initBeanFromGetObject2 = ac.getBean(InitFromGetObjectMethodBean.class);
		System.out.println(initBeanFromGetObject2);

		System.out.println("执行完毕");
	}
}

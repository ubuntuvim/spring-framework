package com.ubuntuvim.spring.createbean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import javax.annotation.PostConstruct;

/**
 * 验证不同方式初始化回调的执行顺序：
 * 0. 执行初始化回调BeanPostProcessor.postProcessBeforeInitialization()方法
 * 1. 执行初始化回调@PostConstruct注解定义的方法
 * 2. 执行初始化回调InitializingBean.afterPropertiesSet()方法
 * 3. 执行初始化回调@Bean(initMethod = "beanInit")定义的方法
 * 4. 执行初始化回调BeanPostProcessor.postProcessAfterInitialization()方法
 * 5. 执行初始化回调SmartInitializingSingleton.afterSingletonsInstantiated()方法，
 * 		此回调是在bean实例化和初始化完成之后执行的
 *
 * @Author: ubuntuvim
 * @Date: 2020/10/18 上午1:16
 */
public class InitCallbackBean implements InitializingBean, SmartInitializingSingleton {

	/**
	 * 如果一个类中多个方法都使用@PostConstruct注解声明，则会根据方法名按照字母升序顺序执行。
	 * 比如init()和afterPropertiesSet()都加了注解，那么先执行afterPropertiesSet()方法
	 */
	@PostConstruct
	public void init() {
		System.out.println("执行初始化回调@PostConstruct注解定义的方法");
	}

	@PostConstruct
	public void init2() {
		System.out.println("执行初始化回调@PostConstruct注解定义的方法init2()");
	}

	/**
	 * 如果用户在afterPropertiesSet()方法上也使用了@PostConstruct注解，此方法在后置处理器中会先被执行
	 * @see InitDestroyAnnotationBeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 * 然后在执行初始化回调接口InitializingBean时不会再次执行。
	 * @see AbstractAutowireCapableBeanFactory#invokeInitMethods(String, Object, RootBeanDefinition)
	 * 也就是说同时在回调接口InitializingBean上同时使用@PostConstruct注解只会执行一次，但是可以改变方法的执行时机，
	 * 比如本类中init()和afterPropertiesSet()都加了@PostConstruct注解，那么先执行afterPropertiesSet()方法，
	 * 如果afterPropertiesSet()方法不加@PostConstruct注解，那么会先执行init()方法，再执行afterProperties()方法。
	 * 因为@PostConstruct注解优先于回调接口InitializingBean执行
	 *
	 * 如果@Bean注解中自定义的方法也使用@PostConstruct注解声明，那么这个方法会重复执行。
	 * 1. 后置处理器处理@PostConstruct注解方法的时候执行一次，
	 * 2. 执行自定义的方法的时候也执行一次
	 *
	 * @Bean(initMethod = "afterPropertiesSet")
	 * 如果自定义的方法和InitializingBean的回调方法一致。
	 * afterPropertiesSet()方法会执行一次，只执行InitializingBean的回调，不会在执行自定义方法的回调。
	 * 原因可以看Spring源码，位置：
	 * @see AbstractAutowireCapableBeanFactory#invokeInitMethods(String, Object, RootBeanDefinition)
	 *
	 * @Bean(initMethod = "initBean")
	 * 如果自定义的方法也使用了@PostConstruct声明，那么initBean()会执行两次。
	 * 1. 后置处理器处理@PostConstruct注解方法的时候执行一次，
	 * 2. 执行自定义的方法的时候也执行一次
	 *
	 * 总结一句话，InitializingBean.afterPropertiesSet()方法只会执行一次。
	 * 			@PostConstruct 声明的方法都会执行，不管有几个，执行顺序按照方法名升序执行
	 */
//	@PostConstruct
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("执行初始化回调InitializingBean.afterPropertiesSet()方法");
	}

	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("执行初始化回调SmartInitializingSingleton.afterSingletonsInstantiated()方法");
	}

	@PostConstruct
	private void beanInit() {
		System.out.println("执行初始化回调@Bean(initMethod = \"beanInit\")定义的方法");
	}
}

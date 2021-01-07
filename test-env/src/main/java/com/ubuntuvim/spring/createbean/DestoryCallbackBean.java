package com.ubuntuvim.spring.createbean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.support.AbstractApplicationContext;

import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * 和InitCallbackBean是相互呼应的，有销毁回调对应着就有销毁的回调。
 * 验证各种销毁回调方法的执行顺序：
 * 1. 执行销毁回调DestructionAwareBeanPostProcessor.postProcessBeforeDestruction()方法
 * 2. 执行销毁回调@PreDestroy注解的回调方法twoDestroy()
 * 3. 执行销毁回调@PreDestroy注解的回调方法oneDestroy()
 * 4. 执行销毁回调DisposableBean.destory()方法
 * 5. 执行销毁回调@Bean(destroyMethod = "beanDestoryCallbackMethod")的方法
 *
 * 需要注意的是，这些销毁的回调方法需要手动调用容器的关闭方法才会触发。触发方法如下：
 * @see AbstractApplicationContext#close()
 * 最终会调用到这个类的方法处理上述回调接口。
 * @see DisposableBeanAdapter#destroy()
 *
 * @Author: ubuntuvim
 * @Date: 2020/10/18 下午5:17
 */
public class DestoryCallbackBean implements DisposableBean, /*Closeable, */AutoCloseable {

	// 实现DisposableBean接口的方法
	@Override
	public void destroy() throws Exception {
		System.out.println("执行销毁回调DisposableBean.destory()方法");
	}

	// 自定义销毁方法：@Bean(destroyMethod = "beanDestoryCallbackMethod")
	private void beanDestoryCallbackMethod() {
		System.out.println("执行销毁回调@Bean(destroyMethod = \"beanDestoryCallbackMethod\")的方法");
	}
	// 如果有一个同名销毁方法会不会被读取使用？？不会，因为@Bean只支持无参方法
	private void beanDestoryCallbackMethod(Fruit apple) {
		apple.eatable();
		System.out.println("执行销毁回调@Bean(destroyMethod = \"beanDestoryCallbackMethod\")的方法");
	}

	/**
	 * 如果一个类中有两个方法都使用了@PreDestory注解会怎么执行？
	 * 都会执行，执行代码：
	 * @see DefaultSingletonBeanRegistry#destroySingletons()
	 * 但是如果DispoableBean的destory()方法也使用了@PreDestory注解则只会执行一次。
	 * 这个和初始化的InitializingBean.afterPropertiesSet()方法类似，只会执行一次。
	 */
	@PreDestroy
	public void twoDestroy() {
		System.out.println("执行销毁回调@PreDestroy注解的回调方法twoDestroy()");
	}
	@PreDestroy
	public void oneDestroy() {
		System.out.println("执行销毁回调@PreDestroy注解的回调方法oneDestroy()");
	}

	/**
	 * 实现接口AutoCloseable的方法。
	 * bean没有实现任何销毁回调，也没有在@Bean中自定义任何销毁方法下，当容器执行close事件时此方法会被执行。
	 * 比如SimpleDestoryBean类的例子。
	 * @throws IOException
	 */
	@Override
	public void close() throws IOException {
		System.out.println("执行销毁回调Closeable.close()方法");
	}
	
	public void shutdown() {
		System.out.println("执行销毁回调shutdown()方法");
	}

}

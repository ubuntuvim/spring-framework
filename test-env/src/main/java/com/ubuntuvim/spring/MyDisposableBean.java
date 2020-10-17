package com.ubuntuvim.spring;/**
 * @Author: ubuntuvim
 * @Date: 2020/5/6 00:59
 */

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * bean生命周期回调方法测试，当每个bean被销毁的时候会调用destroy方法，
 * 除了实现DisposableBean接口之外还有另外一种不依赖于spring框架的方法
 * 同样可以实现bean被销毁的时候调用某个方法，使用注解@PreDestroy
 * 注意：这两种方式执行的顺序是先执行@PreDestroy方法，再执行接口destroy()方法。
 * 		这两个方式都会在容器关闭的时候执行，比如显示调用applicationContext.close()方法的时候
 * @Author: ubuntuvim
 * @Date: 2020/5/6 00:59
 */
@Component
public class MyDisposableBean implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("\n\n执行destroy方法\n\n");
	}

	@PreDestroy  // 这是jdk的注解，不需要依赖Spring
	public void destroyNotDependencySpring() {
		System.out.println("\n\n执行destroyNotDependencySpring方法\n\n");
	}
}

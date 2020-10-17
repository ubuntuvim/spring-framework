package com.ubuntuvim.spring.beanfactorypostprocessor;


import org.springframework.stereotype.Component;

/**
 * 这个bean在MyBeanFactoryPostProcessorImpl中被设置懒加载了，所以容器启动完毕也会不打印构造方法的日志
 * @Author: ubuntuvim
 * @Date: 2020/9/23 下午10:32
 */
@Component
public class LazyLoadingBean {
	public LazyLoadingBean() {
		System.out.println("\n" + this.getClass().getName() + "被加载了。。。\n");
	}
}

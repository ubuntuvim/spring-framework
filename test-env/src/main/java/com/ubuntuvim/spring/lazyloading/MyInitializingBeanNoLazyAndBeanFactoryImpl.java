package com.ubuntuvim.spring.lazyloading;


import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 同时实现了Bean初始化方法和FactoryBean方法的类，是否可以做到懒加载？？
 * 答案是做不到，由于在afterPropertiesSet方法中调用了工厂bean的生成方法，使得当前类必须被实例化，否则无法实现工厂bean功能无法创建有工厂bean创建的对象。
 * 无论getObject方法做什么操作本类都会被实例化。
 * 即使在类上使用@Lazy注解，在getObject方法上使用@Lazy注解，在afterPropertiesSet方法上使用@Lazy注解都是无效的。
 * 因为FactoryBean是用于向容器注册bean的，它自己必须先实例化了才能执行getObject，才能向容器注册bean。
 * 简单讲，只要是实现了FactoryBean的类都无法做到懒加载。
 *
 * 需要注意的是通过FactoryBean.getObject()方法创建的bean不会在容器启动的时候就实例化。当创建的bean用到的时候才实例化，
 * 也就是说同FactoryBean.getObject()方法创建的bean默认是懒加载的
 * 但是一个同时实现了InitializingBean, FactoryBean这两个接口，并且在afterPropertiesSet方法里再调用了getObject()方法
 * 就可以做到在容器启动的时候就做初始化，因为实现FactoryBean接口的类会在容器启动的时候实例化，由于被实例化了所以afterPropertiesSet方法就会被容器自动调用。
 * 组合起来就实现了实时加载。
 *
 * @Author: ubuntuvim
 * @Date: 2020/7/17 23:58
 */
//@Lazy  // 无效
public class MyInitializingBeanNoLazyAndBeanFactoryImpl implements InitializingBean, FactoryBean<InitFromGetObjectMethodBean> {

	public MyInitializingBeanNoLazyAndBeanFactoryImpl() {
		System.out.println(this.getClass().getName() + "被加载了");
	}

	//	@Lazy  // 无效
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(this.getClass().getName() + " afterPropertiesSet()方法被调用了 =====");
		// 即使子类使用了@Lazy注解父类的afterPropertiesSet方法也会被调用的。
		// 但是如果本类被另外一个类引用了，但是在引用的属性上也使用了@Lazy注解，那么本类可是懒加载
		System.out.println("name的值是：" + this.name + "\n");
		getObject();  // 即使不调用getObject方法也做不到懒加载，容器在启动的时候就会实例化当前类
	}

	/**
	 * 通过xml注入
	 */
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 无论这个方法做什么操作都会在容器启动的时候初始化，无法做到延迟加载
	 *
	 * @return
	 * @throws Exception
	 */
//	@Lazy  // 无效
	@Override
	public InitFromGetObjectMethodBean getObject() throws Exception {
		System.out.println(this.getClass().getName() + "的getObject方法被调用");
		return new InitFromGetObjectMethodBean();
	}

	@Override
	public Class<?> getObjectType() {
		return InitFromGetObjectMethodBean.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}

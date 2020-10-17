package com.ubuntuvim.spring.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @Configuration/@Bean注解使用
 * @Bean注解等价于使用<bean></bean>标签注册bean
 * @Author: ubuntuvim
 * @Date: 2020/5/17 00:21
 */
@Configuration
public class BeanConfig {

	@Bean(name = "myServiceImpl")
	// 等价于使用如下xml配置
	//  <bean id="myServiceImpl" class="com.ubuntuvim.spring.bean.MyServiceImpl"/>
	// 默认情况Bean的名字就是方法的名字
	public MyService myServiceImpl() {
		return new MyServiceImpl();
	}

	// 指定beanName，
	@Bean(name = "serviceInstance")
	public MyServiceImpl2 getServiceInstance() {
		return new MyServiceImpl2();
	}

	@Bean
	public MyServiceCommonImpl getCommonInstance() {
		return new MyServiceCommonImpl();
	}

	// 如下两个Bean都通过setter方法注入了另外一个实例MyServiceCommonImpl
	// 由于spring默认都是单例的，所以这两个Bean注入的是同一个MyServiceCommonImpl实例
	@Bean(name = "myServiceImpl1")
	@Scope(scopeName = SCOPE_PROTOTYPE)
	public MyService myServiceImpl1() {
		MyServiceImpl service = new MyServiceImpl();
		service.setMyServiceCommonImpl(getCommonInstance());
		return service;
	}

	@Bean(name = "myServiceImpl2")
	@Scope(scopeName = SCOPE_PROTOTYPE)
	public MyService myServiceImpl2() {
		MyServiceImpl service = new MyServiceImpl();
		service.setMyServiceCommonImpl(getCommonInstance());
		return service;
	}

//	@Bean
//	public DataSource dataSource() {
//		return new EmbeddedValueResolutionSupport();
//	}
}

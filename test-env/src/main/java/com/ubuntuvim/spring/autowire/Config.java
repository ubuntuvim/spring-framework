package com.ubuntuvim.spring.autowire;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@Configuration
@EnableAspectJAutoProxy
public class Config {

	/**
	 * 自定义一个AutowiredAnnotationBeanPostProcessor对象实例
	 * 借助AutowiredAnnotationBeanPostProcessor完成自定义注解的依赖注入，
	 * 从运行结果看，Person对象里面的两个属性都成功注入。
	 * 但是直接把后置处理器类和其他普通bean放在同一个@Configuration中，会导致其他bean过早初始化。
	 * 可能会导致无法享受容器在初始化的时候执行的其他后置处理器的服务，具体例子还没找到。
	 * @return
	 */
	@Bean
	public AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor() {
		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setAutowiredAnnotationType(MyAutowired.class);
		return autowiredAnnotationBeanPostProcessor;
	}

	@Bean
	public Apple apple() {
		return new Apple();
	}

	@Bean
	public Banana banana() {
		return new Banana();
	}

	@Bean
	public Orange orange() {
		return new Orange();
	}

//	@Bean
//	public DataSource dataSource() throws NamingException {
//		Context ctx = new InitialContext();
//		return (DataSource) ctx.lookup("java:comp/env/jdbc/datasource");
//	}
}


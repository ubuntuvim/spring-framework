package com.ubuntuvim.spring.lazyloading;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 未使用@Lazy注解，但是子类使用@Lazy注解，是否可以实现延迟加载呢？答案是不行，@Lazy只对当前类起效果。
 * <p>
 * xml方式定义bean可以实现懒加载，因为不是继承方式，这种方式就是别名的方式，MyInitializingBeanSubClassUseLazy instanceOf MyInitializingBeanNoLazy => true
 * <bean name="myInitializingBeanSubClassUseLazy" class="com.ubuntuvim.spring.lazyloading.MyInitializingBeanNoLazy" lazy-init="true">
 * <property name="name" value="使用了Lazy-init=true，父类的afterPropertiesSet方法也会被调用" />
 * </bean>
 * <p>
 * 但是，当另外一个类BeanA里面引用了myInitializingBeanSubClassUseLazy，也不能实现懒加载，因为BeanA在设置属性的时候会先初始化myInitializingBeanSubClassUseLazy。
 *
 * @Author: ubuntuvim
 * @Date: 2020/7/17 21:26
 */
@Component
public class MyInitializingBeanNoLazy implements InitializingBean {

	public MyInitializingBeanNoLazy() {
		System.out.println(this.getClass().getName() + "被加载了");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("=====" + this.getClass().getName() + "的afterPropertiesSet()方法被调用了 =====");
		// 即使子类使用了@Lazy注解父类的afterPropertiesSet方法也会被调用的。
		System.out.println("name的值是：" + this.name + "\n");
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
}

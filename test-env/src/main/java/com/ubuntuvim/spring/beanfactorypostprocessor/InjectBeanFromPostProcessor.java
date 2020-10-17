package com.ubuntuvim.spring.beanfactorypostprocessor;


/**
 * 通过BeanDefinitionRegistryPostProcessor接口注入本类到容器中。
 * 并没有在类上使用任何注解，也没有通过其他方式导入容器，期望效果是容器启动完毕之后会打印构造方法的日志
 * @Author: ubuntuvim
 * @Date: 2020/9/23 下午11:00
 */
public class InjectBeanFromPostProcessor {
	public InjectBeanFromPostProcessor() {
		System.out.println("\n" + this.getClass().getName() + "被加载了。。。\n");
	}
}

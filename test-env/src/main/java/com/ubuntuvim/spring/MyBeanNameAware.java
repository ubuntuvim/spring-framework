package com.ubuntuvim.spring;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * 在填充正常的bean属性之后但在初始化回调（例如InitializingBean ， afterPropertiesSet或自定义init-method）之前调用该回调.
 * BeanNameAware:实现该接口的Bean能够在初始化时知道自己在BeanFactory中对应的名字。
 * @Author: ubuntuvim
 * @Date: 2020/5/16 16:47
 */
@Component
public class MyBeanNameAware implements BeanNameAware {
	@Override
	public void setBeanName(String name) {
		System.out.println("BeanNameAware接口实例化时会自动把当前类在容器中的BeanName注入到次：" + name);
	}
}

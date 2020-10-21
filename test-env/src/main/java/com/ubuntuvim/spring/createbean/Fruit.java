package com.ubuntuvim.spring.createbean;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @see AbstractAutowireCapableBeanFactory#populateBean(String, RootBeanDefinition, BeanWrapper)
 * 验证复杂属性是否在applyPropertyValues()方法处理的
 * 比如下面这2种写法，会把所有接口实现类注入到这个List/Map中。
 * @Autowired
 * private List<InterfaceA> interfaceAList;
 * 同理，Map也是一样的
 * @Autowired
 * private Map<String, InterfaceA> interfaceAMap;
 * key就是实现类的beanName，value就是实现类实例对象。
 * @Author: ubuntuvim
 * @Date: 2020/10/17 下午10:57
 */
public interface Fruit {
	void eatable();
}

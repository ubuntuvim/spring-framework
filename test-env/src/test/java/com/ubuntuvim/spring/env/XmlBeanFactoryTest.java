package com.ubuntuvim.spring.env;


import com.ubuntuvim.spring.TestBean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * 创建一个XmlBeanFactory容器
 * @Author: ubuntuvim
 * @Date: 2020/8/16 上午11:13
 */
public class XmlBeanFactoryTest {
	public static void main(String[] args) {
		// 从类路径读取包含bean定义的xml资源文件
		ClassPathResource classPathResource = new ClassPathResource("spring-env-test.xml");
		// 创建一个DefaultListableBeanFactory
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// 创建XmlBeanDefinitionReader读取器，用于加载xml并转换成BeanDefinition，然后装在到容器defaultListableBeanFactory中
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		// 执行解析并加载bean定义
		reader.loadBeanDefinitions(classPathResource);

		TestBean testBean = factory.getBean(TestBean.class);
		System.out.println(testBean);
	}
}

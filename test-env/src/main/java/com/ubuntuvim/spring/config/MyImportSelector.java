package com.ubuntuvim.spring.config;


import com.ubuntuvim.spring.beanfactorypostprocessor.LazyLoadingBean;
import com.ubuntuvim.spring.bean.MyImportSelectorBean;
import com.ubuntuvim.spring.beanfactorypostprocessor.MyBeanFactoryPostProcessorImpl;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 在AnnotationConfigApplicationContextConfig中通过@ImportSelector注解导入本类
 * @Author: ubuntuvim
 * @Date: 2020/9/21 下午10:57
 */
public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {
				MyImportSelectorBean.class.getName(),
				LazyLoadingBean.class.getName(),
				MyBeanFactoryPostProcessorImpl.class.getName()
		};
	}
}

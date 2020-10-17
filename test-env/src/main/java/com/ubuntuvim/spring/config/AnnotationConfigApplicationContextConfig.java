package com.ubuntuvim.spring.config;


import com.ubuntuvim.spring.beanfactorypostprocessor.LazyLoadingBean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * @Author: ubuntuvim
 * @Date: 2020/9/14 下午10:54
 */
@ComponentScan(
		basePackages = {
				"com.ubuntuvim.spring.bean",
				"com.ubuntuvim.spring.processor"
		}
		,
		includeFilters = {
				@Filter(type = FilterType.ASSIGNABLE_TYPE, value = LazyLoadingBean.class),
				@Filter(type = FilterType.ANNOTATION, value = Component.class)
		}
)
@Configuration
//@Import(MyImportSelector.class)
//@ImportResource(locations = "com/ubuntuvim/main/resource/dao.xml")
public class AnnotationConfigApplicationContextConfig extends AnnotationConfigApplicationContextConfigParent {
//	@Bean
//	public MyService myServiceImpl() {
//		return new MyServiceImpl();
//	}
//
//	@Configuration
//	public class AnnotationConfigApplicationContextConfigInner {
//		@Bean
//		public InnerConfiguration innerConfiguration() {
//			return new InnerConfiguration();
//		}
//	}
}

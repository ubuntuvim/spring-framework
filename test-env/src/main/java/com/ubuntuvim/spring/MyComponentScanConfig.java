package com.ubuntuvim.spring;/**
 * @Author: ubuntuvim
 * @Date: 2020/5/16 22:23
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @ComponentScan注解使用，等同于使用如下配置
 * <context:component-scan base-package="com.acme">
 *     <context:include-filter />
 *     <context:exclude-filter />
 * </context:component-scan>
 * @Author: ubuntuvim
 * @Date: 2020/5/16 22:23
 */
//@Configuration
//@ComponentScan(
//		basePackages = "com.ubuntuvim.spring.xxx", //指定自动扫描的包路径
//		// 指定扫描包路径下，使用类Component注解的类
//		includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, pattern = "org.springframework.stereotype.Component"),
//		// 用于指定排除不扫描的类，使用类@Repository注解的类都会被排除掉，不会被Spring容器自动实例化
//		excludeFilters = @ComponentScan.Filter(Repository.class)
//
//)
public class MyComponentScanConfig {
}

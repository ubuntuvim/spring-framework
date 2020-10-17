package com.ubuntuvim.spring;

import com.ubuntuvim.spring.bean.MyService;
import com.ubuntuvim.spring.bean.MyServiceImpl;
import com.ubuntuvim.spring.bean.MyServiceImpl2;
import com.ubuntuvim.spring.scan.MyScanPath;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 编程方式指定扫描的包路径
 * @Author: ubuntuvim
 * @Date: 2020/5/17 00:10
 */
public class EnvScanTest {
	public static void main(String[] args) {
		// 可以不通过构造方法把扫描配置传过去，
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		// 编程方式指定包扫描路径
		ctx.scan("com.ubuntuvim.spring.scan", "com.ubuntuvim.spring.bean");
		ctx.refresh();  // 显式调用容器刷新方法
		MyScanPath myScanPath = ctx.getBean(MyScanPath.class);
		System.out.println(myScanPath);

		MyService myServiceImpl = ctx.getBean(MyServiceImpl.class);
//		myServiceImpl.test();

		// 通过BeanName获取实例
		MyService myService = (MyServiceImpl2) ctx.getBean("serviceInstance");
//		myService.test();

		MyServiceImpl service1 = (MyServiceImpl) ctx.getBean("myServiceImpl1");
		MyServiceImpl service2 = (MyServiceImpl) ctx.getBean("myServiceImpl2");
		System.out.println(service1.getMyServiceCommonImpl() == service2.getMyServiceCommonImpl());
	}
}

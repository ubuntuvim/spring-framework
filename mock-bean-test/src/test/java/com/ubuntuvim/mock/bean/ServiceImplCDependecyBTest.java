package com.ubuntuvim.mock.bean; 

import com.ubuntuvim.mock.listener.MockitoDependencyInjectionTestExecutionListener;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.Mock;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

/** 
* ServiceImplCDependecyB Tester. 
* 
* @author <Authors name> 
* @since <pre>5月 22, 2020</pre> 
* @version 1.0 
*/
@ContextConfiguration(classes = {ServiceImplCDependecyBTest.class})
//@TestExecutionListeners({
//		MockitoDependencyInjectionTestExecutionListener.class
//})
@ComponentScan(
		basePackages = {
			"com.ubuntuvim.mock"
		},
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
												// 排除不需要Spring容器自动初始化的类
												value = {
														ServiceImplA.class
//														,ServiceImplBDependecyA.class
												}
											)
)
public class ServiceImplCDependecyBTest extends AbstractJUnit4SpringContextTests {

//	@Mock
//	ServiceImplA serviceImplA;
//	@Mock
//	ServiceImplBDependecyA serviceImplBDependecyA;

//	@Inject
	//这个类会在执行时被注入，这里是按类型注入，如果想按名称注入，需要加上@Named注解，如@Named("class1")
	//实现类可以加上@Named("class1")注解，也可以是配置在配置文件中的
//	Class1 class1;

	// 真正使用的C类
	@Resource
	ServiceImplCDependecyB serviceImplCDependecyB;

   @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception { 
    } 

        /** 
	* 
	* Method: msg(String tip) 
	* 
	*/ 
	@Test
	public void testMsg() throws Exception {
		// C类依赖的A类和B类都通过Mock处理掉了，理论上A、B类都不会被容器实例化
		// 使用Mock方法把A类和B类的方法mock掉

		String msg = serviceImplCDependecyB.msg("这个是C类的");
		System.out.println(msg);
	}
	
}

package com.ubuntuvim.spring.service.impl; 

import com.ubuntuvim.spring.bean.MyService;
import com.ubuntuvim.spring.processor.MockitoBeansTestExecutionListener;
import com.ubuntuvim.spring.service.UserService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.doReturn;

/** 
* MyServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>5月 20, 2020</pre> 
* @version 1.0 
*/
@TestExecutionListeners({MockitoBeansTestExecutionListener.class})
@ContextConfiguration(classes = {MyServiceImplTest.class})
@ComponentScan(basePackages = {
		"com.ubuntuvim.spring.service.impl",
		"com.ubuntuvim.spring.processor"
})
public class MyServiceImplTest extends AbstractJUnit4SpringContextTests {
	@Resource
	MyService myServiceImpl;
	@Resource
	UserServiceImpl userServiceImpl;

//	@Test
//	public void testHello() {
//		doReturn("ubuntuvim")
//				.when(userServiceImpl.getName())
//				;
//	}

	@Test
	public void testPrint() {
		userServiceImpl.setUserName("ubuntuvim test.");
		myServiceImpl.hello();
	}
}

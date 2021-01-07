package com.ubuntuvim.spring.autowire;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

//	@Pointcut("execution(* com.xys.service.UserService.*(..))") // 切点表达式
	@Before("execution(public * com.ubuntuvim.spring.autowire.Person.test())")
	public void log() {
		System.out.println("Person.test()被拦截了");
	}
}

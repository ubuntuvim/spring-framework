package com.ubuntuvim.mock.listener;


import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/22 23:05
 */
public class MockitoDependencyInjectionTestExecutionListener extends DependencyInjectionTestExecutionListener {

	private Set<Field> injectFields = new HashSet<>();
	private Map<String,Object> mockObjectMap = new HashMap<>();
	@Override
	protected void injectDependencies(TestContext testContext) throws Exception {
		super.injectDependencies(testContext);
		System.out.println("\n\nMockitoDependencyInjectionTestExecutionListener\n\n");
		init(testContext);
	}

	/**
	 * when A dependences on B
	 * mock B or Spy on targetObject of bean get from Spring IoC Container whose type is B.class or beanName is BImpl
	 * @param testContext
	 */
	private void init(TestContext testContext) throws Exception {

		AutowireCapableBeanFactory factory =testContext.getApplicationContext().getAutowireCapableBeanFactory();
		//拿到serviceImplCDependecyB实例
		Object bean = testContext.getTestInstance();
		// 拿到实例的所有属性
//		0 = {Field@2614} "com.ubuntuvim.mock.bean.ServiceImplA com.ubuntuvim.mock.bean.ServiceImplCDependecyBTest.serviceImplA"
//		1 = {Field@2615} "com.ubuntuvim.mock.bean.ServiceImplBDependecyA com.ubuntuvim.mock.bean.ServiceImplCDependecyBTest.serviceImplBDependecyA"
//		2 = {Field@2616} "com.ubuntuvim.mock.bean.ServiceImplCDependecyB com.ubuntuvim.mock.bean.ServiceImplCDependecyBTest.serviceImplCDependecyB"
		Field[] fields = bean.getClass().getDeclaredFields();

		for (Field field : fields) {
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				if(annotation instanceof Mock){
					Class<?> clazz = field.getType();
					Object object = Mockito.mock(clazz);
					field.setAccessible(true);
					field.set(bean, object);
					mockObjectMap.put(field.getName(), object);
				} else if(annotation instanceof Spy) {
					//may be a proxy that can not be spy because $Proxy is final
					Object fb = factory.getBean(field.getName());
					System.out.println("fb = " + fb);
					Object targetSource = AopTargetUtils.getTarget(fb);
					Object spyObject = Mockito.spy(targetSource);
					if (!fb.equals(targetSource)) {
						if (AopUtils.isJdkDynamicProxy(fb)) {
							setJdkDynamicProxyTargetObject(fb, spyObject);
						} else { //cglib
							setCglibProxyTargetObject(fb, spyObject);
						}
					} else {
						mockObjectMap.put(field.getName(), spyObject);
					}
					field.setAccessible(true);
					field.set(bean, spyObject);
				}else if (annotation instanceof Autowired){
					injectFields.add(field);
				}
			}
		}
		for(Field field: injectFields) {
			field.setAccessible(true);
			Object fo = field.get(bean);
			if (AopUtils.isAopProxy(fo)) {
				Class<?> targetClass = AopUtils.getTargetClass(fo);
				if (targetClass == null) {
					return;
				}
				Object targetSource = AopTargetUtils.getTarget(fo);
				Field[] targetFields =targetClass.getDeclaredFields();
				for(Field targetField : targetFields){
					targetField.setAccessible(true);
					if(mockObjectMap.get(targetField.getName()) == null){
						continue;
					}
					ReflectionTestUtils.setField(targetSource,targetField.getName(), mockObjectMap.get(targetField.getName()));
				}

			} else {
				Object realObject = factory.getBean(field.getType());
				if(null != realObject) {
					Field[] targetFields = realObject.getClass().getDeclaredFields();
					for(Field targetField : targetFields){
						targetField.setAccessible(true);
						if(mockObjectMap.get(targetField.getName()) == null){
							continue;
						}
						ReflectionTestUtils.setField(fo,targetField.getName(), mockObjectMap.get(targetField.getName()));
					}
				}
			}
		}
	}

	private void setCglibProxyTargetObject(Object proxy, Object spyObject) throws NoSuchFieldException, IllegalAccessException {
		Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
		h.setAccessible(true);
		Object dynamicAdvisedInterceptor = h.get(proxy);
		Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
		advised.setAccessible(true);
		((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).setTarget(spyObject);

	}

	private void setJdkDynamicProxyTargetObject(Object proxy, Object spyObject) throws NoSuchFieldException, IllegalAccessException {
		Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
		h.setAccessible(true);
		AopProxy aopProxy = (AopProxy) h.get(proxy);
		Field advised = aopProxy.getClass().getDeclaredField("advised");
		advised.setAccessible(true);
		((AdvisedSupport) advised.get(aopProxy)).setTarget(spyObject);
	}
}

//package com.ubuntuvim.spring.processor;
//
//
//import java.lang.reflect.Field;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import org.springframework.test.context.TestContext;
//import org.springframework.test.context.support.AbstractTestExecutionListener;
//import org.springframework.util.Assert;
//
///**
// * @Author: ubuntuvim
// * @Date: 2020/5/20 23:19
// */
////@Component
//public class MockitoBeansTestExecutionListener extends AbstractTestExecutionListener {
//
//	static final Map<Class<?>, MockBeanWrapper> mockBeans = new ConcurrentHashMap<>(32);
//	static final Map<Class<?>, List<Field>> injectMockBeans = new ConcurrentHashMap<>(32);
//	static boolean hasInitializd = false;
//
//	public static Map<Class<?>, MockBeanWrapper> resolvedAllMockBeans() {
//		System.out.println("\n\nMockitoBeansTestExecutionListener resolvedAllMockBeans\n\n");
//		System.out.println(mockBeans);
//		Assert.isTrue(hasInitializd, "hasInitializd不能为true");
//		return Collections.unmodifiableMap(mockBeans);
//	}
//
//	@Override
//	public void beforeTestClass(TestContext testContext) throws Exception {
//		Field[] declaredFields = testContext.getTestClass().getDeclaredFields();
//		System.out.println("declaredFields = " + declaredFields);
//		// 将需要mock的对象创建处理
//		for (Field field : declaredFields) {
//			Mock mockAnnotaction = field.getAnnotation(Mock.class);
//			if (null != mockAnnotaction) {
//				MockBeanWrapper mbw = new MockBeanWrapper();
//				Class<?> classType = field.getType();
//				mbw.setMockObject(Mockito.mock(classType));
//				mbw.setBeanType(classType);
//				mbw.setBeanName(field.getName());
//				mockBeans.putIfAbsent(mbw.getBeanType(), mbw);
//				injectMockBeans.compute(testContext.getTestClass(), (targetClass, waitInjectFields) -> {
//					if (waitInjectFields == null) {
//						waitInjectFields = new ArrayList<>();
//					}
//					waitInjectFields.add(field);
//					return waitInjectFields;
//				});
//			}
//		}
//		hasInitializd = true;
//	}
//
//	@Override
//	public void beforeTestMethod(TestContext testContext) throws Exception {
//		Object testInstance = testContext.getTestInstance();
//		List<Field> fields = injectMockBeans.get(testContext.getTestClass());
//		if (fields != null) {
//			for (Field field : fields) {
//				field.setAccessible(true);
//				field.set(testInstance, mockBeans.get(field.getType()).getMockObject());
//			}
//		}
//	}
//
//
//	public class MockBeanWrapper {
//		String beanName;
//		Class<?> beanType;
//		Object mockObject;
//
//		public String getBeanName() {
//			return beanName;
//		}
//
//		public void setBeanName(String beanName) {
//			this.beanName = beanName;
//		}
//
//		public Class<?> getBeanType() {
//			return beanType;
//		}
//
//		public void setBeanType(Class<?> beanType) {
//			this.beanType = beanType;
//		}
//
//		public Object getMockObject() {
//			return mockObject;
//		}
//
//		public void setMockObject(Object mockObject) {
//			this.mockObject = mockObject;
//		}
//	}
//}

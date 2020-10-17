package com.ubuntuvim.mock.listener;


import lombok.extern.java.Log;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Field;

/**
 * @Author: ubuntuvim
 * @Date: 2020/5/22 23:13
 */
@Log
public class AopTargetUtils {

	public static Object getTarget(Object proxy) throws Exception {
		if (!AopUtils.isAopProxy(proxy)) {
			return proxy;
		}
		if (AopUtils.isJdkDynamicProxy(proxy)) {
			return getJdkDynamicProxyTargetObject(proxy);
		} else {
			return getCglibProxyTargetObject(proxy);
		}
	}

	private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
		Field h = proxy.getClass().getDeclaredField("h");
		h.setAccessible(true);
		AopProxy aopProxy = (AopProxy) h.get(proxy);
		Field advised = aopProxy.getClass().getDeclaredField("advised");
		advised.setAccessible(true);
		Object target = ((AdvisedSupport)advised.get(proxy)).getTargetSource().getTarget();
		System.out.println("getCglibProxyTargetObject target = " + target);
		return target;
	}

	private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
		Field field = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
		field.setAccessible(true);
		Object dynamicAdvisedIntercpter = field.get(proxy);
		Field advised = dynamicAdvisedIntercpter.getClass().getDeclaredField("advised");
		advised.setAccessible(true);
		Object target = ((AdvisedSupport)advised.get(dynamicAdvisedIntercpter)).getTargetSource().getTarget();
		System.out.println("getJdkDynamicProxyTargetObject target = " + target);
		return target;
	}
}

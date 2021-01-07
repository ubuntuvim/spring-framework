package com.ubuntuvim.spring.createbean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 自定义销毁回调的后置处理器
 * @Author: ubuntuvim
 * @Date: 2020/10/18 下午5:23
 */
@Component
public class MyDestructionAwareBeanPostProcessorImpl implements DestructionAwareBeanPostProcessor {
	@Override
	public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
		if ("DestoryCallbackBean".equalsIgnoreCase(beanName))
			System.out.println("执行销毁回调DestructionAwareBeanPostProcessor.postProcessBeforeDestruction()方法");
	}

	@Override
	public boolean requiresDestruction(Object bean) {
		// 返回true，表示需要执行销毁回调方法postProcessBeforeDestruction()
		return true;
	}
}

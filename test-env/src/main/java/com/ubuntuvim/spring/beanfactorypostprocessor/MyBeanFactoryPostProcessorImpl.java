package com.ubuntuvim.spring.beanfactorypostprocessor;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 使用Spring的一个扩展点，实现BeanFactoryPostProcess接口。
 * 1. 修改某个bean的定义信息
 * 2. 接口实现来显式设置为懒加载，看是否有效果（正常情况下应该是无效果的，Spring需要保证实现类提前初始化，否则谈何能修改bean定义）
 *		容器启动的过程中就会打印构造方法的日志
 *
 * 运行结果：
 * com.ubuntuvim.spring.processor.MyBeanFactoryPostProcessorImpl被加载了。。。
 * com.ubuntuvim.spring.bean.LazyLoadingBean被设置成懒加载了。
 *
 * 没有看到LazyLoadingBean被加载的日志，把beanFactory.getBeanDefinition(beanName).setLazyInit(true);改成false再运行：
 * com.ubuntuvim.spring.processor.MyBeanFactoryPostProcessorImpl被加载了。。。
 * com.ubuntuvim.spring.bean.LazyLoadingBean被设置成懒加载了。
 *
 * com.ubuntuvim.spring.bean.LazyLoadingBean被加载了。。。
 *
 * 可以看到LazyLoadingBean被加载了，完美的验证了前面的两点描述
 *
 * @Author: ubuntuvim
 * @Date: 2020/9/23 下午9:17
 */
@Component
@Lazy  // 显式指定为懒加载
public class MyBeanFactoryPostProcessorImpl implements BeanFactoryPostProcessor {
	public MyBeanFactoryPostProcessorImpl() {
		System.out.println("\n" + this.getClass().getName() + "被加载了。。。\n");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// @Component注解没有指定名称，所有是默认首字母小写名字
		String beanName = "lazyLoadingBean";
		System.out.println("\n" + beanName + "被设置成懒加载了。\n");
		beanFactory.getBeanDefinition(beanName).setLazyInit(true);
	}
}

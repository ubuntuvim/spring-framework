/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

/**
 * Factory hook that allows for custom modification of an application context's
 * bean definitions, adapting the bean property values of the context's underlying
 * bean factory.
 *
 * <p>Useful for custom config files targeted at system administrators that
 * override bean properties configured in the application context. See
 * {@link PropertyResourceConfigurer} and its concrete implementations for
 * out-of-the-box solutions that address such configuration needs.
 *
 * <p>A {@code BeanFactoryPostProcessor} may interact with and modify bean
 * definitions, but never bean instances. Doing so may cause premature bean
 * instantiation, violating the container and causing unintended side-effects.
 * If bean instance interaction is required, consider implementing
 * {@link BeanPostProcessor} instead.
 *
 * <h3>Registration</h3>
 * <p>An {@code ApplicationContext} auto-detects {@code BeanFactoryPostProcessor}
 * beans in its bean definitions and applies them before any other beans get created.
 * A {@code BeanFactoryPostProcessor} may also be registered programmatically
 * with a {@code ConfigurableApplicationContext}.
 *
 * <h3>Ordering</h3>
 * <p>{@code BeanFactoryPostProcessor} beans that are autodetected in an
 * {@code ApplicationContext} will be ordered according to
 * {@link org.springframework.core.PriorityOrdered} and
 * {@link org.springframework.core.Ordered} semantics. In contrast,
 * {@code BeanFactoryPostProcessor} beans that are registered programmatically
 * with a {@code ConfigurableApplicationContext} will be applied in the order of
 * registration; any ordering semantics expressed through implementing the
 * {@code PriorityOrdered} or {@code Ordered} interface will be ignored for
 * programmatically registered post-processors. Furthermore, the
 * {@link org.springframework.core.annotation.Order @Order} annotation is not
 * taken into account for {@code BeanFactoryPostProcessor} beans.
 *
 * 允许自定义修改容器中的bean定义信息，调整bean定义属性值。
 * 容器会在所有bean定义信息加载完毕之后回调此接口，用以修改容器中的bean定义信息。
 * 但是不要在此接口直接通过getBean实例化bean，这样会导致bean过早实例化，违反容器规则导致不可预知的副作用。
 * 如果要实现bean实例化请通过BeanPostProcessor接口。
 * 如果有多个BeanFactoryPostProcessor接口并且需要执行它们的执行顺序可以同时实现PriorityOrdered接口或者Ordered接口。
 *
 * 简单讲就是，我们可以通过实现此接口获取到BeanFactory对象（就是参数），操作BeanFactory对象，修改里面的BeanDefinition。
 * 但是不要去实例化bean。
 *
 * 另外有一点需要注意的是此接口的实现类会忽略懒加载设置，即使你显式设置了实现类懒加载也是不生效的。
 * 因为Spring需要保证BeanFactoryPostProcessor实现类优先实例化，如果实现类都懒加载了，那么你又如何能修改容器的bean定义呢。。。
 *
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 06.07.2003
 * @see BeanPostProcessor
 * @see PropertyResourceConfigurer
 */
@FunctionalInterface
public interface BeanFactoryPostProcessor {

	/**
	 * 在所有的bean定义被加载到容器中后，并且是在所有bean实例化之前就会回调这个接口，
	 * 这个接口可以修改容器中的所有bean定义信息，包括重写某些bean的定义属性信息。
	 * 比如修改MyServiceImpl为懒加载：beanFactory.getMergedBeanDefinition(MyServiceImpl.class.getName()).setLazyInit(true);
	 * 另外一个很典型的应用就是修改bean定义中属性的占位符（PropertySourcesPlaceholderConfigurer），比如读取配置文件把配置文件的配置值注入到类属性上
	 * 最常见的就是@Value("${xxxx}")
	 *
	 * 注意：不要在此接口中实例化bean（就是不要调getBean()方法），提前实例化bean会导致不可预知的结果，
	 * 因为目前还处在解析完所有bean定义阶段，bean的实例化（实例化就是根据bean的定义信息创建实例对象）还在后面的阶段。
	 *
	 * Modify the application context's internal bean factory after its standard
	 * initialization. All bean definitions will have been loaded, but no beans
	 * will have been instantiated yet. This allows for overriding or adding
	 * properties even to eager-initializing beans.
	 * @param beanFactory the bean factory used by the application context
	 * @throws org.springframework.beans.BeansException in case of errors
	 */
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}

package com.ubuntuvim.spring;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

/**
 * SmartLifecycle 在容器所有bean加载和初始化完毕执行
 * 有时候我们需要在Spring加载和初始化所有bean后，接着执行一些任务或者启动需要的异步服务，这样我们可以使用 SmartLifecycle 来做到。
 * SmartLifecycle 是一个接口。当Spring容器加载所有bean并完成初始化之后，会接着回调实现该接口的类中对应的方法（start()方法）。
 * https://www.jianshu.com/p/7b8f2a97c8f5
 * @Author: ubuntuvim
 * @Date: 2020/5/6 01:33
 */
@Component
public class MySmartLifecycle implements SmartLifecycle {

	static boolean isRunning = false;

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	/**
	 * SmartLifecycle接口的方法，仅当isRunning()返回true的时候执行。
	 *
	 * 如果你让isRunning返回true，需要执行stop这个方法，那么就不要忘记调用callback.run()。
	 * 否则在你程序退出时，Spring的DefaultLifecycleProcessor会认为你这个TestSmartLifecycle没有stop完成，
	 * 程序会一直卡着结束不了，等待一定时间（默认超时时间30秒）后才会自动结束。
	 * PS：您可以通过在上下文中定义一个名为lifecycleProcessor的bean来覆盖默认的生命周期处理器实例. 如果只想修改超时，则定义以下内容即可
	 * <bean id="lifecycleProcessor" class="org.springframework.context.support.DefaultLifecycleProcessor">
	 * 		<!-- timeout value in milliseconds -->
	 *      <property name="timeoutPerShutdownPhase" value="10000"/>
	 * </bean>
	 * @param callback
	 */
	@Override
	public void stop(Runnable callback) {
		System.out.println("\n\npublic void stop(Runnable callback)");
		callback.run();
	}

	@Override
	public int getPhase() {
		return 0;
	}

	/**
	 * 可以在此方法中启动一下任务或者异步任务，比如启动mq，
	 * 当上下文所有的bean都被实例化后就会调用次方法。
	 * 默认生命周期处理器将检查每个SmartLifecycle对象的isAutoStartup()方法返回的布尔值。
	 * 仅当isAutoStartup()方法返回true的时候start()方法才会被执行，否则不会被执行。
	 */
	@Override
	public void start() {
		System.out.println("\n\n public void start() ");
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("\n\n使用异步方式启动一个MQ\n\n");
			}
		}).start();
		// isRunning()方法返回true之后才会被执行
		isRunning = true;
	}

	/**
	 * Lifecycle接口的方法，实现了此接口的bean手动调用stop方法的时候才会被执行。spring不会自动执行此方法
	 */
	@Override
	public void stop() {
		System.out.println("======== stop() ===========");
	}

	/**
	 * 1. 只有该方法返回false时，start方法才会被执行。<br/>
	 * 2. 只有该方法返回true时，stop(Runnable callback)或stop()方法才会被执行。
	 */
	@Override
	public boolean isRunning() {
		return isRunning;
	}
}

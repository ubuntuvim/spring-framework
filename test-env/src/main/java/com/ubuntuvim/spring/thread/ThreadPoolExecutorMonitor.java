package com.ubuntuvim.spring.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 扩展ThreadPoolExecutor，实现对线程池运行监控
 */
public class ThreadPoolExecutorMonitor extends ThreadPoolExecutor {

	public ThreadPoolExecutorMonitor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
//		System.out.println("getActiveCount = " + super.getActiveCount());
//		System.out.println("getCorePoolSize = " + super.getCorePoolSize());
//		System.out.println("getPoolSize = " + super.getPoolSize());
//		System.out.println("getQueue().size() = " + super.getQueue().size());
//		System.out.println("getTaskCount = " + super.getTaskCount());
//		System.out.println("beforeExecute执行任务的线程：" + t);
//		System.out.println("beforeExecute被执行的任务" + r);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
	}

	public static void main(String[] args) throws Exception {
		// 系统启动时，读取数据配置并初始化线程池
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
				2,
				10,
				2,
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(10));

		Map<String, Integer> params = new HashMap<>();
		params.put("k1", 123);

		// 模拟往线程池中put任务的情况
		for (int i = 0; i < 50; i++) {
			poolExecutor.execute(() -> {
				// 对params进行频繁的putAll操作。
				Map map = doSomething();
				params.putAll(map);
			});
		}

		// 关闭线程池
//		poolExecutor.shutdown();
	}

	private static Map doSomething() {
		return new HashMap();
	}


}

class MyThread extends Thread {
	String name;
	int i;
	Map<String, Integer> params;

	public MyThread(String name, int i, Map<String, Integer> params) {
		this.name = name;
		this.i = i;
		this.params = params;
	}
	@Override
	public void run() {
		// 对params进行频繁的putAll操作。
		Map map = doSomething();
		params.putAll(map);
	}

	private Map doSomething() {
		return new HashMap();
	}
}
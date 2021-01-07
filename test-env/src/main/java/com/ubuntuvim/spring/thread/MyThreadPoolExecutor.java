package com.ubuntuvim.spring.thread;

import java.util.concurrent.*;

public class MyThreadPoolExecutor {
	public static void main(String[] args) {
		// 线程池维护线程的最少数量
		int corePoolSize = 2;
		// 线程池维护线程的最大数量
		int maximumPoolSize = 4;
		// 线程池维护线程所允许的空闲时间的单位
		// TimeUnit.SECONDS
		// 线程池维护所允许的空闲时间
		long keepAliveTime = 10;
		// 线程池所使用的缓存队列，当任务达到最大线程数时会把任务放在缓冲队列中，然后有空的线程会逐个执行里面的任务
		int workQueueSize = 50;
		/**
		 * 处理任务的优先级为：核心线程corePoolSize、最大线程maximumPoolSize、任务队列workQueue，如果三者都满了
		 * 使用handler处理被拒绝的任务
		 * corePoolSize -> maximumPoolSize -> workQueueSize
		 * 一开始启动，线程池有两个线程可以接收并处理任务，但是任务比较耗时一下子就来了很多任务，导致2个线程无法满足，
		 * 此时 corePoolSize < maximumPoolSize所以可以创建新的线程接收任务，就有了4个线程在接收任务。
		 * 但是任务量还是很多，四个线程仍然无法完全处理，只能把任务放在缓冲队列中，4个线程在处理任务的同时把处理不过来的任务放在缓冲队列
		 * 但是缓冲队列也是有上限的，它的上限是4，也就是说只能缓冲4个任务。
		 * 如果任务量太大，并且每个任务都处理很耗时。导致缓冲队列也满了。
		 * 这种情况下就会抛出拒绝任务异常java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution（这个是默认的拒绝异常）
		 *
		 * 验证：
		 * 1. 缓冲队列设置比较小，比如workQueueSize=5时，很容易就出现任务拒绝异常
		 * 2. 如果直接设置缓冲队列workQueueSize=50，肯定不会有问题。所有任务都可以放到缓冲队列中，等待线程池中的线程来处理即可。
		 */
		// 定义一个线程池
		ThreadPoolExecutor executor = new ThreadPoolExecutor(
				corePoolSize,
				maximumPoolSize,
				keepAliveTime,
				TimeUnit.SECONDS,
				// ArrayBlockingQueue是有界的缓冲队列
				new ArrayBlockingQueue<>(workQueueSize));

		for (int i = 1; i <= 50; i++) {
			try {
				System.out.println("i = " + i);
				int task = i;
				executor.execute(() -> {
					System.out.println(Thread.currentThread().getName() + "在执行任务：\t" + task);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
				System.out.println("getActiveCount = " + executor.getActiveCount());
				System.out.println("getTaskCount = " + executor.getTaskCount());
				System.out.println("getCompletedTaskCount = " + executor.getCompletedTaskCount());
				System.out.println("getMaximumPoolSize = " + executor.getMaximumPoolSize());
				System.out.println("workQueueSize = " + executor.getQueue().size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		executor.shutdown();
	}
}

package com.ubuntuvim.spring.env;

import org.junit.Test;

/**
 * @Author: ubuntuvim
 * @Date: 2020/4/25 00:39
 */
public class SynchronizedTest {


	final Object lock = new Object();


	@Test
	public void testLock() {
		/// 线程锁，同一个线程可以多次拿到这个锁？？

		// 第一次拿到锁
		synchronized (lock) {
			System.out.println("第一次拿到lock" + lock + " thread id = " + Thread.currentThread().getId());
		}
		// 另外一个线程
		getLockForOtherThrean();

		getLock();
	}

	private void getLockForOtherThrean() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("getLockForOtherThrean start.....");
				synchronized (lock) {
					System.out.println("getLockForOtherThrean " + lock + ", thread id =" + Thread.currentThread().getId());
				}
			}
		}).start();
	}

	private void getLock() {
		synchronized (lock) {
			System.out.println("在子方法里面获取锁：" + lock + " thread id = " + Thread.currentThread().getId());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

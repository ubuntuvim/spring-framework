package com.ubuntuvim.mock.bean;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用两个线程：一个线程输出数字，一个线程输出字母，但是数字和字母要交替输出
 * @Author: ubuntuvim
 * @Date: 2020/5/24 02:08
 */
public class ThreadSwitchTest {

	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		condition.await();
		condition.signal();
	}
}

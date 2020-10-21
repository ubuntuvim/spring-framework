package com.ubuntuvim.spring.createbean;

import org.junit.Test;
import org.springframework.lang.Nullable;

/**
 * @Author: ubuntuvim
 * @Date: 2020/10/17 下午10:04
 */
public class NullTest {

	@Test
	public void main() {
		f("fef");
		f(null);
	}

	private void f(@Nullable String s) {

	}
}

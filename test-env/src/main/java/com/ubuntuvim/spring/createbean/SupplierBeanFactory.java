package com.ubuntuvim.spring.createbean;

import java.util.function.Supplier;

/**
 * @Author: ubuntuvim
 * @Date: 2020/10/17 下午4:46
 */
//@Component
public class SupplierBeanFactory implements Supplier<SupplierBean> {
	@Override
	public SupplierBean get() {
		return new SupplierBean();
	}
}

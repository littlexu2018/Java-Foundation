package com.xuhh.foundation.jdkProxy;

/**
 * @Author: xuhh
 * @Description:
 * @Date: Created in 23:47 2018/10/11
 * @Modified By:
 */
public class ProductServiceImpl implements ProductService {
	@Override
	public void addProduct(String productName) {
		System.out.println("正在添加"+productName);

	}
}

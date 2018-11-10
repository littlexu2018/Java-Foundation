package com.xuhh.foundation.observer;

/**
 * @Author: xuhh
 * @Description:
 * @Date: Created in 8:50 2018/11/10
 * @Modified By:
 */
public class MyStockObserver implements Observer{
	@Override
	public void update() {
		System.out.println("库存服务收到通知");
	}
}

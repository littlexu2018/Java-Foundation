package com.xuhh.foundation.observer;

/**
 * @Author: xuhh
 * @Description:
 * @Date: Created in 8:58 2018/11/10
 * @Modified By:
 */
public class App {
	public static void main(String[] args) {

		// "支付状态更新"->看做一个事件，可以被监听的事件

		// 被观察者。即事件源
		MyPaymentStatusUpdateSubject myPaymentStatusUpdateSubject = new MyPaymentStatusUpdateSubject();

		// 观察者。即事件监听器
		MyEmailObserver myEmailObserver = new MyEmailObserver();
		MyStockObserver myStockObserver = new MyStockObserver();

		// 添加观察者。
		myPaymentStatusUpdateSubject.addObserver(myEmailObserver);
		myPaymentStatusUpdateSubject.addObserver(myStockObserver);

		// 发布事件。支付状态更新。
		myPaymentStatusUpdateSubject.updatePaymentStatus(3);
	}
}

package com.xuhh.foundation.observer;

/**
 * @Author: xuhh
 * @Description:
 * @Date: Created in 8:51 2018/11/10
 * @Modified By:
 */
public interface Subject {

	void addObserver(Observer observer);

	void removeObserver(Observer observer);
	/*
		通知观察者
	 */
	void notifyObservers();
}

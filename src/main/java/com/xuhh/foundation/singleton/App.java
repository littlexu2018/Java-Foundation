package com.xuhh.foundation.singleton;

/**
 * @Author: xuhh
 * @Description:
 * @Date: Created in 12:37 2018/10/28
 * @Modified By:
 */
public class App {
	public static void main(String[] args) {
		HungrySingleton hungrySingleton = HungrySingleton.getSingleton();
		HungrySingleton hungrySingleton2 =HungrySingleton.getSingleton();


	}
}

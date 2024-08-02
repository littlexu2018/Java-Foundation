package com.xuhh.foundation.singleton;

/**
 * @Author: xuhh
 * @Description:这就是传说中的 饿懒汉单例模式
 * 大体思路是，发现对象是null，就new一个，否则就不new对象
 * 问题一：为啥在构造方法上加private？
 *         是为了不让别人随意的new对象
 * 问题二：为啥要用static方法new对象？
 * 			已经变成private了，所以就要用static，static能让单例的创建出来的
 * 		    对象让大家共享
 *
 * @Date: Created in 12:40 2018/10/28
 * @Modified By:
 */
public class HungrySingleton {
	private static HungrySingleton singleton =null;
	private   HungrySingleton(){
		System.out.println("创建对象");
	}

	public static HungrySingleton getSingleton(){
		if (singleton==null){
			System.out.println("没对象，创建一个");
			return new HungrySingleton();
		}
		System.out.println("已经有对象啦");
		return singleton;
	}
}

package com.xuhh.foundation.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: xuhh
 * @Description:
 * @Date: Created in 23:45 2018/10/11
 * @Modified By:
 */
public class JdkInvocationHandler implements InvocationHandler {
	private ProductService target;

	public Object getInstance(ProductService target){
		this.target=target;
		Class clazz =this.target.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String currentDate  = simpleDateFormat.format(new Date());
		System.out.println("日期【"+currentDate + "】添加了一款产品");
		System.out.println("试一下提交代码上去！！！！！");
		return method.invoke(this.target,args);

	}
}

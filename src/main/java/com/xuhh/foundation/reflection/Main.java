package com.xuhh.foundation.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception{
//        Address address = new Address("345 Street", "10086");
//        Customer customer = new Customer("xuhh", "xuhh@123.com");
//        Order order = new Order(address, customer);
//        System.out.println("order = " + order.getAddress()+"\n"+order.getCustomer());
        //上面就是一个简单的对象初始化依赖的例子，接下来将会用反射去实现依赖注入的过程，
        // 让初始化Order对象的时候，自动注入address和order

        ////   2------------------
        //        Container container =new Container();
//        container.init();
//
//        Class<?> clazz = Class.forName("com.xuhh.foundation.reflection.Message");
//        Object obj = container.getServiceInstanceByClass(clazz);
//        System.out.println("obj = " + obj);
            ////2------------------
            ////3-----Start-------
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Class<?> clazz = Class.forName("com.xuhh.foundation.reflection.Order");
        Container container =new Container();
        container.init();
        Object obj = container.createInstance(clazz);
        Field field = clazz.getDeclaredField("customer");
        field.setAccessible(true);
        Object fieldValue = field.get(obj);
        Method[] declaredMethods = fieldValue.getClass().getDeclaredMethods();
        for (Method method:declaredMethods){
            System.out.println("method = " + method);
        }
        //本质就是通过字符串和 注解可以直接实现 对象依赖的注入，只要注解和字符串比较规范即可
        ////3-----End-------
    }
}

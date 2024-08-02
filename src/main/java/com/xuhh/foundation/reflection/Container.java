package com.xuhh.foundation.reflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.xml.ws.Action;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Container {

    private Map<Class<?>, Method> methods;
    private Object config;
    //避免对象反复被创建
    private Map<Class<?>,Object> services=new HashMap<>();

    public void init() throws Exception {
        this.methods = new HashMap<>();
        Class<?> clazz = Class.forName("com.xuhh.foundation.reflection.Config");
        Method[] methods=clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Container 打印Config类 里面所有的方法的名称 = " + method.getName());
            //如果我们只想要注解为 @Bean 的方案，其他的不打印
            if(method.getDeclaredAnnotation(Bean.class)!=null){
                System.out.println("打印有Bean注解的方法 = " + method.getName());
                this.methods.put(method.getReturnType(),method);
            }
        }
        this.config=clazz.getConstructor().newInstance();
    }

    public Object  getServiceInstanceByClass(Class<?> clazz) throws InvocationTargetException, IllegalAccessException {

        //避免对象被多次创建
        if(this.services.containsKey(clazz)){
            return services.get(clazz);
        }else {
            if(this.methods.containsKey(clazz)){
                Method method = this.methods.get(clazz);
                //method.invoke方法主要是用来 通过 方法名称 传入对象实例来调用实例中的方法。
                Object object= method.invoke(this.config);
                services.put(clazz,object);
                return object;
            }
        }
       return null;
    }

    /**
     *用于通过class 对象创建普通实例，并且实现将服务自动注入到对象里面
     */
    public Object createInstance(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Constructor<?>[] constructors = clazz.getConstructors();
        //获取到所有的构造器
        for (Constructor<?> constructor : constructors) {
            //获取构造器上面的注解
            if(constructor.getDeclaredAnnotation(Autowired.class)!=null){
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] arguments=new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    arguments[i]=getServiceInstanceByClass(parameterTypes[i]);
                }
                return constructor.newInstance(arguments);
            }
        }
        return clazz.getConstructor().newInstance();
    }
}

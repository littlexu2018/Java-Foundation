package com.xuhh.foundation.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class User {

    private  int age;
    private  String name;
    private  final  String  address="武汉市-洪山区";
    private  String career;
    public User(){

    }
    public User(int age,String name){this.age=age;this.name=name;
    }
    public  void syaHi(String who){
        System.out.println( who+": User say hi  ");
    }
    static {System.out.println("static method!!!");}
    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", career='" + career + '\'' +
                '}';
    }

    public static void main(String[] args) throws Exception{
        Class<?> userClass = Class.forName("com.xuhh.foundation.reflection.User");
        Constructor<?> constructor = userClass.getConstructor(int.class, String.class);
        Object object = constructor.newInstance(18, "徐浩浩");
        User user = (User) object;
        System.out.println("user = " + object);

        Field address = userClass.getDeclaredField("address");
        address.setAccessible(true);
        address.set(object,"北京市-海淀区");
        System.out.println("address = " + address.get(object));

        Method syaHiMethod = userClass.getDeclaredMethod("syaHi", String.class);
        syaHiMethod.invoke(object,"xuhh");
    }
}

package com.xuhh.foundation.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
  public  static   int count=0;
  public static  Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

    }

    public static void methopd1(){
        synchronized (lock){// 先创建出一个锁记录，锁记录的对象的地址 指向object对象的地址
                            // 锁记录
            //同步代码块儿A
            methopd2();
        }
    }
    public static void methopd2(){
        synchronized (lock){
            //同步代码块儿B

        }
    }
}

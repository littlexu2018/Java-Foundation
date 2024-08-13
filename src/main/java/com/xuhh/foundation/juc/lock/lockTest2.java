package com.xuhh.foundation.juc.lock;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 实现一个简单的计数器，模拟同一时间有5000个用户，最多只有200个用户进行操作
 */
public class lockTest2 {
    //threadTotal=5000  clientTotal=200 模拟5000请求，允许200个用户同时运行
    private static int threadTotal = 5000;
    private static int clientTotal = 200;
    private static int count= 0;
    private static ReentrantReadWriteLock lock =new ReentrantReadWriteLock();
    Lock readLock=lock.readLock();
    Lock writeLock=lock.writeLock();
    Map<String, Date> map =new TreeMap<>();


    public Date  get(String key){
        Date date;
        readLock.lock();
        try{
            date = map.get(key);
        }finally {
            readLock.unlock();
        }
        return date;
    }


    public Date put(String key,Date value){
        Date date;
        readLock.lock();
        try{
            date = map.put(key,value);
        }finally {
            readLock.unlock();
        }
        return date;
    }
}

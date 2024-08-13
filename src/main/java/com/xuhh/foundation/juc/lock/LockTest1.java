package com.xuhh.foundation.juc.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现一个简单的计数器，模拟同一时间有5000个用户，最多只有200个用户进行操作
 */
public class LockTest1 {
    //threadTotal=5000  clientTotal=200 模拟5000请求，允许200个用户同时运行
    private static int threadTotal = 5000;
    private static int clientTotal = 200;
    private static int count= 0;
    private static Lock lock =new ReentrantLock();
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        Semaphore semaphore =new Semaphore(clientTotal);
        for (int i = 0; i < threadTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count = " + count);
    }
    public static  void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}

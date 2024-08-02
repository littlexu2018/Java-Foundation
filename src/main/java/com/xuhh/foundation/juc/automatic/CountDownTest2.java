package com.xuhh.foundation.juc.automatic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 实现一个简单的计数器，模拟同一时间有5000个用户，最多只有200个用户进行操作
 */
public class CountDownTest2 {
    //threadTotal=5000  clientTotal=200 模拟5000请求，允许200个用户同时运行
    private static int threadTotal = 5000;
    private static int clientTotal = 200;
    private static int count = 0;
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        Semaphore semaphore =new Semaphore(clientTotal);
        for (int i = 0; i < threadTotal; i++) {
            executorService.execute(() -> {
                try {
                    // semaphore可以控制同时有200个请求在执行
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    //这个Countdown可以保证前面的线程都执行完成
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();//相当于join去等待 count down到0才行
        //关闭线程池
        executorService.shutdown();
        System.out.println("count = " + count);
    }
    public static  void add() {
        count = count + 1;
    }
}

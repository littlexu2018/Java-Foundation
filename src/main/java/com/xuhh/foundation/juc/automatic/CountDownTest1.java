package com.xuhh.foundation.juc.automatic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 实现一个简单的计数器，模拟同一时间有5000个用户，最多只有200个用户进行操作
 */
public class CountDownTest1 {
    //threadTotal=5000  clientTotal=200 模拟5000请求，允许200个用户同时运行
    private static int threadTotal = 5000;
    private static int clientTotal = 200;
    private static List list= new CopyOnWriteArrayList();
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
        System.out.println("count = " + list.size());
    }
    public static  void add() {
        list.add(new ArrayList<>());
    }
}

package com.xuhh.foundation.juc.automatic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现一个简单的计数器，模拟同一时间有5000个用户，最多只有200个用户进行操作
 */

@Slf4j
public class CyclicBarrierTest1 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final  int threadNum = i+1;
            Thread.sleep(1000);
            executorService.execute(() -> {
                add(threadNum);
            });
        }
        executorService.shutdown();
    }

    public static void add(int threadNum) {
        try {
            Thread.sleep(1000);
            log.info("{},开始等待.......", threadNum);
            cyclicBarrier.await();
            log.info("{},等待完成开始执行.......", threadNum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

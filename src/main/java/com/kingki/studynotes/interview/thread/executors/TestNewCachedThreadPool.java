package com.kingki.studynotes.interview.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存的线程池
 */
public class TestNewCachedThreadPool {
    public static void main(String[] args) {
        //可缓存的线程池:如果线程池的容量超过了任务数，自动回收空闲线程，任务增加时可以自动添加新线程，线程池的容量不限制
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i <6; i++) {
            final int index = i;
            cachedThreadPool.execute(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " index:" + index);
            });
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");

        cachedThreadPool.shutdown();
    }
}

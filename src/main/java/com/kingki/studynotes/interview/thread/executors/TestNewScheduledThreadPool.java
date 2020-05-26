package com.kingki.studynotes.interview.thread.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 延迟线程池(周期性执行任务)
 */
public class TestNewScheduledThreadPool {
    public static void main(String[] args) {

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        for(int i = 0;i < 3;i++){
            final  int index = i;
            scheduledThreadPool.scheduleWithFixedDelay(()->{
                System.out.println(Thread.currentThread().getName() + "index:" + index);
            },2,1, TimeUnit.SECONDS);//initialDelay:初始化延迟时间;delay:延迟时间间隔
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后...");

        scheduledThreadPool.shutdown();
    }
}

package com.kingki.studynotes.interview.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用Executors类创建定长线程池
 */
public class TestNewFixedThreadPool {
    public static void main(String[] args) {
        //创建工作线程数为3的定长线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);


        //提交任务
        for(int i = 0;i < 6;i++){
            final int index = i;
            fixedThreadPool.execute(()->{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "index:" + index);
            });
        }


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("4秒后....");

        fixedThreadPool.shutdown();
    }

}

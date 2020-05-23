package com.kingki.studynotes.interview.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 简单线程池创建(阻塞队列实现生产者-消费者)
 */
public class ThreadPool {

    BlockingQueue<Runnable> blockingQueue;

    List<Thread> threads = new ArrayList<Thread>();

    //线程池构造
    ThreadPool (int poolSize, BlockingQueue<Runnable> blockingQueue){
        this.blockingQueue = blockingQueue;
        for(int i = 0; i < poolSize; i++){//会先创建完所有线程然后同时去获取和执行任务
            final int j = i;
            Thread thread = new Thread(() -> {
                while (true){
                    try {
                        blockingQueue.take().run();
                        System.out.println("任务"+j+"执行完成");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            threads.add(thread);
        }
    }

    //任务放置
    public void execute(Runnable runnable){
        try {
            blockingQueue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.kingki.studynotes.interview.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TestThreadPool {
    public static void main(String[] args) {
        BlockingQueue<Runnable> tasks = new LinkedBlockingDeque();

        ThreadPool threadPool = new ThreadPool(3,tasks);

        for(int i = 0;i < 10;i++){
            final int j = i;
            threadPool.execute(()->{
                System.out.println("任务"+j+"添加完成");
            });
        }


    }
}

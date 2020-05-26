package com.kingki.studynotes.interview.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程线程池:线程异常结束，会创建一个新的线程，能确保任务按提交顺序执行
 */
public class TestNewSingleThreadExecutor {

    public static void main(String[] args) {

        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        //提交 3 个任务
        for (int i = 0; i <3; i++) {
            final int index = i;
            singleThreadPool.execute(() -> {

                //执行第二个任务时，报错，测试线程池会创建新的线程执行任务三
                if (index == 1) {
                    throw new RuntimeException("线程执行出现异常");
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " index:" + index);
            });
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("10秒后...");

        singleThreadPool.shutdown();
    }
}

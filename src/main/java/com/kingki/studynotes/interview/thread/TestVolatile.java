package com.kingki.studynotes.interview.thread;

public class TestVolatile {
    int count = 0;
    public static void main(String[] args) {
        TestVolatile testVolatile = new TestVolatile();

        for(int i = 0;i < 10;i++){
            final  int j = i;
            new Thread(()->{
                System.out.println("Thread" + j);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testVolatile.add();
            }).start();
        }



        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(testVolatile.getCount());
    }


    private void add(){
            count++;
        System.out.println("count:" + count);
    }

    private int getCount(){
        return this.count;
    }
}

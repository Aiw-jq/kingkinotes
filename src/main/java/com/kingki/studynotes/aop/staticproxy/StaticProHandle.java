package com.kingki.studynotes.aop.staticproxy;


/**
 * 代理类
 */
public class StaticProHandle implements StaticProInterface{

    private StaticProTarget target;

    StaticProHandle(StaticProTarget target){
        this.target = target;
    }


    @Override
    public void say() {
        System.out.println("before!!");
        target.say();
        System.out.println("after!!");
    }

    @Override
    public void sayAgain() {
        System.out.println("before!!");
        target.sayAgain();
        System.out.println("after!!");
    }
}

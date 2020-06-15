package com.kingki.studynotes.aop.staticproxy;

public class StaticMain {

    public static void main(String[] args) {
        StaticProTarget target = new StaticProTarget();
        StaticProHandle handle = new StaticProHandle(target);
        handle.say();
        handle.sayAgain();
    }
}

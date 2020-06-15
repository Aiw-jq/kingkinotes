package com.kingki.studynotes.aop.dynamicproxy;

public class ManSayHelloWorld implements ISayHelloWorld {
    @Override
    public String say() {
        System.out.println("Hello World!!!");
        return "Man";
    }

    public String sayAgain() {
        System.out.println("Say Hello World!");
        return "嘤嘤嘤";
    }
}

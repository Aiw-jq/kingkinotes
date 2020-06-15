package com.kingki.studynotes.aop.staticproxy;

public class StaticProTarget implements StaticProInterface{

    @Override
    public void say() {
        System.out.println("say!!!");
    }

    @Override
    public void sayAgain() {
        System.out.println("sayAgain!!!");
    }
}

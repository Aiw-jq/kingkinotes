package com.kingki.studynotes.aop.dynamicproxy;


import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        ManSayHelloWorld sayHelloWorld = new ManSayHelloWorld();
        AOPHandle handle = new AOPHandle(sayHelloWorld);
        ISayHelloWorld i = (ISayHelloWorld) Proxy.newProxyInstance(ManSayHelloWorld.class.getClassLoader(),
                new Class[]{ISayHelloWorld.class},handle);
        i.say();
        sayHelloWorld.sayAgain();
    }

    private static void justSay(){

    }
}

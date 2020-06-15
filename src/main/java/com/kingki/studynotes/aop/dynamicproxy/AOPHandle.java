package com.kingki.studynotes.aop.dynamicproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类:可以对需要相同处理方式的类进行共同处理
 */
public class AOPHandle implements InvocationHandler {
    private Object object;
    public AOPHandle(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置代理");
        Object ret = method.invoke(object,args);
        System.out.println("后置代理");
        return ret;
    }
}

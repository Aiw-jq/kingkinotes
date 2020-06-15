package com.kingki.studynotes.aop.staticproxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.TYPE})
public @interface StaticAnnotion {
    String value() default "change";
    boolean isDelete();
}

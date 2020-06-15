package com.kingki.studynotes.base;

/**
 * 向上造型
 */
public class Modeling{
    public static void main(String[] args) {
        Person son = new Son();
        Modeling modeling = new Modeling();
        modeling.commonEat(son);
    }

    private void commonEat(Person person){
        person.eat();
    }

}

class Person{
    void eat(){
        System.out.println("person");
    }
}

class Father extends Person{
    @Override
    void eat() {
        System.out.println("father");
    }
}

class Mother extends Person{
    @Override
    void eat() {
        System.out.println("mother");
    }
}

class Son extends Person{
    @Override
    void eat() {
        System.out.println("son");
    }
}
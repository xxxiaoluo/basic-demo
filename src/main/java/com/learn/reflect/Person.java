package com.learn.reflect;

public class Person {
    //成员变量
    public String name;
    private int age = 18;
    //成员方法
    public void show(int a){
        System.out.println("show()..."+a);
    }
    private void test(String n){
        System.out.println("test()..."+n);
    }

    //构造方法
    public Person(){

    }

    public Person(String name) {
        this.name = name;
    }

    private Person(int age) {
        this.age = age;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

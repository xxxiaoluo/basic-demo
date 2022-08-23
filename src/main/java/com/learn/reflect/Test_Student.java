package com.learn.reflect;

public class Test_Student {
    public String name = "颜如玉";
    public int age = 16;

    public Test_Student() {

    }

    public Test_Student(String name) {
        this.name = name;
    }

    public Test_Student(int age) {
        this.age = age;
    }

    public Test_Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.print("show..");
    }

    public void test() {
        System.out.print("test..");
    }

    @Override
    public String toString() {
        return "Test_Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

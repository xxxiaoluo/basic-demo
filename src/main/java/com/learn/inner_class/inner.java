package com.learn.inner_class;

public class inner {
    public static void main(String[] args) {
        //调用--成员内部类属性
        Outer.Inner oi = new Outer().new Inner();
        oi.in();
        System.out.println(oi.age);
        //调用--局部内部类的资源 -- 先触发方法
        new Outer().show();

    }
}
    class Outer{
        String name;
        public void show(){
            System.out.println("show...");

            //局部内部类
            class Inner2{
                String name2 = "颜如玉";
                public void test(){
                    System.out.println("test...");
                }
            }
            //正式开始使用局部内部的资源
            Inner2 in2 = new Inner2();
            in2.test();
            System.out.println(in2.name2);
        }

        //成员内部类
        class Inner{
            int age = 22;
            public void in(){
                System.out.println("in...");
            }
        }
    }

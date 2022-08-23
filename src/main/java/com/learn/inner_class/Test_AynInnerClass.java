package com.learn.inner_class;

import java.beans.DesignMode;

/**
 * 测试匿名内部类
 */
public class Test_AynInnerClass {
    public static void main(String[] args) {

//        new Inner().save();
//        new InnerImpl().save();
        //优化方案：匿名内部类----通常配合匿名内部类对象使用

        new Inner(){
            //在匿名内部类中，重写接口里的抽象方法
            //重写接口一
            @Override
            public void save() {
                System.out.println("save...");
            }

        }.save();


        //重写接口二
        //实例化接口
        Innnr in = new Innnr(){

            public void delete() {
                System.out.println("delete...");
            }
            public void update() {
                System.out.println("delete...");
            }

        };//匿名对象一次只干一个活儿
        in.delete();
        in.update();
        //直接创建抽象类的对象,并重写该类里的方法，再调用。
        new Demo(){
            @Override
           public void study(){
                System.out.println("study()...");
            }
        }.study();
    }
}
//定义接口一
interface Inner{
    void save();
}
//定义接口二
interface Tnter{
    void delete();
    void update();
}
//定义接口三
interface Innnr{
    void delete();
    void update();
}
abstract class Demo{
    void study(){

    }
}
//如何使用接口里的功能
//class InnerImpl implements Inner,Inter{
//    @Override
//    public void save(){
//        System.out.println("save()...");
//    }
//
//    public void delete(){
//        System.out.println("delete()...");
//    }
//
//    public void update(){
//        System.out.println("update()...");
//    }
//}
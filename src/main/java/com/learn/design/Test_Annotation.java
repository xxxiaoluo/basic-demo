package com.learn.design;
//测试注解

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test_Annotation {
    public static void main(String[] args) {

    }
}

//1.自定义注解： @interface 注解名
//2.@Target指定注解的位置
@Target({ElementType.METHOD,ElementType.FIELD})//3.Test注解可以出现方法上

 //4.指定注解的生命周期 -- 源码里/class文件里/运行时
@Retention(RetentionPolicy.CLASS)//5.Test注解可以出现在源文件里
@interface Test{
    //添加特殊 的属性----特殊在，使用时可以直接赋值，类似于@Test("123"),其实是@Test(value = "123")的简写
    //给注解添加属性
//    String local();
    String local() default "";//给属性添加默认值，方便后面的使用，使用时可以不用非得赋值了
    String value();
}
//Test注解可以出现在多个位置上
//使用注解
class Holle{
    @Test(local = "name",value = "ui")  //使用注解时，由于注解有属性要求，所以必须赋值
    String name;
    @Test("hi") //1.必须在指定位置使用注解
    public void hi(){
        System.out.println("hi..");
    }
}

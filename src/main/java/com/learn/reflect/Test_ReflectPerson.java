package com.learn.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//测试暴力反射

public class Test_ReflectPerson {
    public static void main(String[] args) throws Exception {
//        method01();//反射成员变量
        method02();
    }
    public static void method01() throws Exception {
        //1.反射class对象
        Class<Person> c1 = Person.class;
        //2.反射成员变量
        Field[] f1 = c1.getDeclaredFields();
        //3.遍历
        for(Field f2 : f1){
            //获取变量名
            System.out.println(f2.getName());
            //获取变量类型
            System.out.println(f2.getType().getName());
        }
        //4.只获取指定的属性
        Field f = c1.getDeclaredField("age");

        //7.设置访问权限,否则IllegaAccessException
        f.setAccessible(true);

        //5.设置值 -- set(m,n) -- m是要给哪个对象 -- n是具体的值
        Person obj = c1.newInstance();
        f.set(obj,100);
        //6.获取属性的值
        System.out.println(f.get(obj));
    }

    public static void method02() throws Exception {
        //1，反射Class对象
        Class<Person> cl1 = Person.class;
        //2.反射成员方法们
        Method[] cl2 = cl1.getDeclaredMethods();
        //3.遍历
        for(Method m : cl2){
            //获取方法名
            System.out.println(m.getName());
        }
        //4.执行指定的方法
        Method m = cl1.getDeclaredMethod("test", String.class);//name 参数是一个字符串，指定所需的方法的简单名称
        //6.设置访问权限
        m.setAccessible(true);
        //5.执行方法 ---- invoke(m,n) -- n是具体的方法需要的
        Object obj = cl1.newInstance();
        m.invoke(obj,"wqer");
    }
}

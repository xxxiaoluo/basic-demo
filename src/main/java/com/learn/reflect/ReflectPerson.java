package com.learn.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectPerson {
    public static void main(String[] args) throws Exception {
//        method1();//通过反射获取成员变量
        method2();//反射获取成员方法
    }


    private static void method1() throws Exception {
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
        //7.想修改变量值，需要设置访问权限
        f.setAccessible(true);

        //5.设置值 -- set(m,n)
        Person per = c1.newInstance();
        f.set(per,101);
        System.out.println(f.get(per));
    }

    private static void method2() throws Exception {
        //1.反射Class对象
        Class<Person> c1 = Person.class;
        //2.反射成员方法们
        Method[] m1 = c1.getDeclaredMethods();
        //3.遍历
        for(Method m2 : m1){
            //获取方法名
            System.out.println(m2.getName());
            //获取方法参数
            Class<?>[] c2 = m2.getParameterTypes();
            System.out.println(Arrays.toString(c2));
        }
        //4.执行指定的方法
        Method m = c1.getDeclaredMethod("test", String.class);
        //5.设置访问权限
        m.setAccessible(true);
        //
        Object obj = c1.newInstance();
        m.invoke(obj,"张波");
    }
}

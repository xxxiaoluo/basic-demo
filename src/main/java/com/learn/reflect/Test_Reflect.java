package com.learn.reflect;

public class Test_Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        method();
    }

    //通过反射技术,获取class对象
    //三种方式
    /**
     * static Class<?> forName(String className)----参数是类的全路径
     * 类名.class
     * 对象.getClass()
     */
    public  static void method() throws ClassNotFoundException {

        // static Class<?> forName(String className)----参数是类的全路径
        Class<?> cl1 = Class.forName("cn.tedu.reflect.Test_Reflect");
        //类名.class
        Class<?> cl2 = Test_Reflect.class;
        //对象.getClass()
        Class<? extends String> cl3 = new String().getClass();

        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
    }
}


package com.learn.reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectStudent {

    public static void main(String[] args) throws Exception {
//        method1();//通过反射，获取class对象和所有构造方法
//        method2();//通过反射获取每个成员方法，方法参数
//        method3();//反射获取成员变量的名字及类型
        method4();
    }


    //反射获取构造方法及构造方法的参数
    private static void method1() {
        //1.获取class对象
        Class<Test_Student> c1 = Test_Student.class;
        //2.获取构造方法们
        Constructor<?> con[] = c1.getConstructors();
        //通过foreach循环获取每个构造方法
        for (Constructor<?> c : con) {
            System.out.println(c);
            Class<?>[] c2 = c.getParameterTypes();
            System.out.println(Arrays.toString(c2));
        }
        System.out.println(c1);
    }

    //反射获取public方法及该方法的参数
    private static void method2() {
        //获取class对象
        Class<?> c1 = Test_Student.class;
        //获取成员方法们
        Method ms[] = c1.getMethods();
        //遍历数组，获取每个Method
        for (Method m : ms) {
            //获取方法名
            System.out.println(m.getName());
            //获取方法参数
            Class<?>[] c2 = m.getParameterTypes();
            System.out.println(Arrays.toString(c2));
        }

    }

    //反射获取成员变量名及变量的类型
    private static void method3() {
        //获取class对象
        Class<?> c1 = Test_Student.class;
        //获取成员变量
        Field[] f1 = c1.getFields();
        //遍历数组，获取每个Fild元素
        for (Field c2 : f1) {
            //获取成员变量名
            System.out.println(c2.getName());
            //获取变量类型
            System.out.println(c2.getType().getName());
        }
    }

    //通过反射创建实例
    //创建class对象
    private static void method4() throws Exception {
        //获取class对象
        Class<Test_Student> c1 = Test_Student.class;
        //创建实例
        //newInstance只会触发无参构造,要保证Test_Student里面要存在空参构造
        Test_Student ts1 = c1.newInstance();
        System.out.println(ts1);

        //需求触发含参构造
        Test_Student c = c1.getConstructor(String.class).newInstance("jack");
        System.out.println(c);
    }
}

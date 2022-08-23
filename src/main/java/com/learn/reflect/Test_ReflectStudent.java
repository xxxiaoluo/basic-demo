package com.learn.reflect;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test_ReflectStudent {
    public static void main(String[] args) throws Exception {
        method01();//通过反射，获取class对象和所有构造方法名及参数
//        method02();//通过反射，获取每个成员方法名，方法参数
//        method03();//通过反射，获取每个成员变量的名字及类型
//        method04();
    }

    public static void method01() {
        //1.获取Class对象
        Class<Test_Student> c1 = Test_Student.class;
        //2.获取--构造方法们
        Constructor<?>[] con = c1.getConstructors();

        //3.foreach循环获取每个构造方法
        for (Constructor<?> c : con) {
            //获取构造方法名
            System.out.println(c);
            //获取构造方法的--参数
            Class<?>[] c2 = c.getParameterTypes();
            System.out.println(Arrays.toString(c2));
        }

        System.out.println(c1);
    }

    //获取方法名及参数
    private static void method02(){
        //1.获取class对象
        Class<?> cl1 = Test_Student.class;
        //2.获取成员方法们
        Method[] ms = cl1.getMethods();
        //3.遍历数组，获取每个Method
        for(Method m : ms){
            //获取方法名
            System.out.println(m.getName());
            //获取方法参数
            Class<?>[] cl2 = m.getParameterTypes();
            System.out.println(Arrays.toString(cl2));
        }
    }

    //获取成员变量 名及变量类型
    private static void method03(){
        //获取class对象
        Class<?> s1 = Test_Student.class;
        //获取成员变量
        Field[] f1 = s1.getFields();
        //遍历数组，获取每个Field
        for(Field f2 : f1){
            //获取变量名
            System.out.println(f2.getName());
            //获取变量类型
            System.out.println(f2.getType().getName());
        }
    }

    //通过反射，创建实例
    //创建class对象
    private static void method04() throws Exception {
        //获取class对象
        Class<Test_Student> c1 = Test_Student.class;
        //创建实例
        Test_Student s1 = c1.newInstance();//newInstance会触发无参构造
        System.out.println(s1);


        //可以触发含参构造方法吗？可以--但是要你指定想要触发的含参构造
        Constructor<Test_Student> c = c1.getConstructor(String.class);
        Test_Student s2 = c.newInstance("jack");
        System.out.println(s2);
    }
}

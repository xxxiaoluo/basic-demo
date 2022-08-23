package com.learn.design;

/**
 * 单例设计模式复习
 */
public class Test2_Desgin {
    public static void main(String[] args) {
        MySingleton m1 = MySingleton.getMy();
        System.out.println(m1);
        System.out.println("-----------------");

        MySingleton2 m2 = MySingleton2.getMy1();
        System.out.println(m2);
    }
}

/**
 * 恶汉式
 */
class MySingleton{
    private MySingleton(){
        System.out.println(my);
        System.out.println("成功");
    }
    private static MySingleton my = new MySingleton();//在还没调用getMy方法的时候，该对象就已创建好了
    static public MySingleton getMy(){
        return my;
    }
}


/**
 * 懒汉式
 * */
class MySingleton2{
    private MySingleton2(){

    }
    private static MySingleton2 my1;
    static public MySingleton2 getMy1(){
        synchronized(MySingleton2.class){

        if (my1 == null){
            my1 = new MySingleton2();
        }
        return my1;
        }
    }
}
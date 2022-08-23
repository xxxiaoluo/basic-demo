package com.learn.design;

//测试单例设计模式
//1.饿汉式

/**
 * 单例设计模式（Singletion）：
 *      保证一个类仅有一个实例
 *     私有构造方法
 *    在类的内部自己new一个准备好
 *   全局访问点
 */
public class Test_Design {
    public static void main(String[] args) {
        MySingletion m1 = MySingletion.getMs();
        System.out.println(m1);

        MySingletion m2 = MySingletion.getMs();
        System.out.println(m1);
    }
}

//class MySingletion{
//    //构造方法私有化--不让外界new
//    private MySingletion(){
//    }
//
//    //外界没法new了，在类内部new好
//    //该成员变量被修饰成静态的原因：是因为为getMs() 关联，静态只能调用静态资源
//    private static MySingletion ms = new MySingletion();
//
//    //对外界提供全局访问点--公共的get()
//    //加static的原因：想要被外界能用到此方法
//    public static MySingletion getMs(){
//        return ms;//把ms返回给外界的调用位置
//    }

    //2.懒汉式
    class MySingletion{
        //构造方法私有化--不让外界new
        private MySingletion(){
        }

        //外界没法new了，在类内部new好
        //该成员变量被修饰成静态的原因：是因为为getMs() 关联，静态只能调用静态资源
        private static MySingletion ms;

        //对外界提供全局访问点--公共的get()
        //加static的原因：想要被外界能用到此方法
        public static MySingletion getMs() {

            //饿汉式有线程安全隐患----共享资源被多条语句操作了--加锁--锁的对象是类名.class(共享资源是静态)
            synchronized (MySingletion.class) {
                //懒汉式：不会第一时间new对象来占用着内存，而是什么时候get，就什么时候new--延迟加载
                if (ms == null) {
                    ms = new MySingletion();
                }
                return ms;//把ms返回给外界的调用位置
            }
        }
}
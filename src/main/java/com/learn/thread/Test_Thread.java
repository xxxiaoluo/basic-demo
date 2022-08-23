package com.learn.thread;

//模拟多线程售票  ---- 继承Thread
public class Test_Thread {
    public static void main(String[] args) {
        //测试
        //每次实例化时，都会跟着对象初始化一次，4个对象就各自拥有一个。
        //解决方案一：把共享资源tickets加static修饰,变成全局变量唯一共享
        Thread th1 = new MyTickets();
        Thread th2 = new MyTickets();
        th1.start();
        th2.start();

        //--问题1:总共需要卖出100张票,但是,现在却卖出了400张票.为什么?
        //成员变量tickets,每次实例化时,都会跟着对象初始化一次.4个对象就各自拥有一个tickets,总共变成了400张
        //--问题1的解决方案:把共享资源tickets加static修饰,变成全局唯一全局共享
        //目前来看,程序中的4个线程完美的配合着卖了100张票.
        //但是,数据最终有没有安全隐患--让程序休眠一会儿
    }
}
class MyTickets extends Thread{

    //需求：2个窗口卖出100张票
    static int tickets = 100;//定义变量，记录票数

    //目前程序中，由于在多线程编程中，出现了多个线程抢占资源而造成的数据信息
    //加载来解决数据安全隐患问题，考虑以下两个问题：
    //1，锁的位置：把会有问题的代码锁起来，从问题源头开始，到结束为止，都包起来
    //2，锁的对象： 当使用锁，把代码块锁起来后，需要考虑锁对象是谁？可以是任意对象，只要是同一个对象就行
    //3, 同步锁也可以直接锁方法，默认是用的锁对象是this
    //4, 如果共享资源是一个静态资源，锁对象必须是类名.class

    //开始售票 ---- 把业务放入run()
    Object obj = new Object();
    @Override
    public void run() {
        //一直卖，卖完结束
        while(true){

            synchronized(MyTickets.class){//从头到尾都是锁对象

            if(tickets > 0){

                //让程序休眠一会，来检测侧多线程的安全隐患
                //问题：超卖，卖出了0号票甚至-1号票
                //问题：重卖：同一张票卖给好几个人
                try {
                    Thread.sleep(10);//!!!!!让程序睡10毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName()+":"+tickets--);
            }else{
                break;
            }
        }
        }
    }
}

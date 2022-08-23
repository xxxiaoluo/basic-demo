package com.learn.design;

/**
 * 多线程程序写好后，无论有无问题都要写入sleep()方法，使其短暂睡眠
 *
 */
class Test_Design_Runnable {
    //模拟多线程售票 ----实现接口Runnable
    public static void main(String[] args) {
        //需求两个窗口卖出100张票
        MyThread target = new MyThread();
        Thread th1 = new Thread(target);
        Thread th2 = new Thread(target);

        th1.start();
        th2.start();
    }
}
class MyThread implements  Runnable{

    static int tickets = 100;//定义票数
    //开始抢票 ---- 把业务放入run()方法中
    @Override
    public void run(){
        //一直卖，卖完结束
        while(true) {

            synchronized (MyThread.class) {//锁的对象要为线程关联的同一个，如果成员变量是static修饰要用本类名.class解决。
                try {
                    Thread.sleep(10);//sleep,检测该多线程是否有超卖，重卖的现象，出现了用同步锁synchronized锁住它
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + " , " + tickets--);
                }
            }
        }
    }
}
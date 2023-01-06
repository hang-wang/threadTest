package com.company.thread;

/**
 * 线程礼让
 * 礼让不一定成功
 */
public class TestYieldThread{
    public static void main(String[] args) {
        MyYield myYield=new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();

    }


}
class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        Thread.yield();//线程礼让
        System.out.println(Thread.currentThread().getName()+"线程结束");

    }
}

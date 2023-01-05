package com.company.thread;

//创建线程方式1：继承Thread类 重写run（）方法 调用start开启线程
//注意：线程开启不一定立即执行，由cpu调度执行
public class TestThread extends Thread{
    @Override
    public void run() {
       //run 方法
        for (int i=0;i<20;i++){
            System.out.println("我在看代码-----"+i);
        }
    }

    public static void main(String[] args) {
        //main方法 主线程

        //创建一个线程对象
        TestThread testThread=new TestThread();
        //调用start开启线程
        testThread.start();
        for (int i=0;i<20;i++){
            System.out.println("我在学习多线程-----"+i);
        }
    }
}

package com.company.thread;

//创建线程方法2: 实现runnable 接口，重写run方法， 执行线程要丢入runnable接口实现类，调用start方法
public class TestRunnable implements Runnable {
    @Override
    public void run() {
        //run 方法
        for (int i=0;i<20;i++){
            System.out.println("我在看代码-----"+i);
        }
    }

    public static void main(String[] args) {
        //main方法 主线程

        //创建一个Runnable接口实现类独享
        TestRunnable testThread=new TestRunnable();
//        Thread thread=new Thread(testThread);
//        //调用start开启线程
//        thread.start();
        new Thread(testThread).start();
        for (int i=0;i<20;i++){
            System.out.println("我在学习多线程-----"+i);
        }
    }
}

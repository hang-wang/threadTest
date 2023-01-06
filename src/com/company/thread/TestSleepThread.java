package com.company.thread;

/**
 * 模拟延时:放大问题的发生性
 */
public class TestSleepThread implements Runnable{

    //票数
    private int ticketNums=10;
    @Override
    public void run() {
        while(true){
            if(ticketNums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        TestSleepThread ticket=new TestSleepThread();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"小红").start();
        new Thread(ticket,"小蓝").start();

    }
}

package com.company.thread;

//多线程操作同一个对象
//买火车票例子
//发现问题：多个线程操作同一个资源的情况下,线程不安全
public class Ticket  implements Runnable{

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
        Ticket ticket=new Ticket();
        new Thread(ticket,"小明").start();
        new Thread(ticket,"小红").start();
        new Thread(ticket,"小蓝").start();

    }
}

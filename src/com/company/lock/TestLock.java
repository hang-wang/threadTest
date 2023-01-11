package com.company.lock;

import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
//synchronized封装太好啦 不够显式
public class TestLock {

    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(ticket).start();
        new Thread(ticket).start();
        new Thread(ticket).start();

    }

}
class Ticket implements Runnable{
    int ticketNum=10;
    //定义lock锁
    //可重入锁
    private  final ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                //加锁
                lock.lock();
                if(ticketNum>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNum--);
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}
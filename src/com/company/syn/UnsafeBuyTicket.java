package com.company.syn;

//不安全的买票
//线程不安全，有负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket=new BuyTicket();
        new Thread(buyTicket,"我").start();
        new Thread(buyTicket,"你").start();
        new Thread(buyTicket,"黄牛").start();
    }
}
class BuyTicket implements Runnable{

    private  int ticketNums=10;
    private boolean flag=true;
    @Override
    public void run() {
        while (flag){
           Buy();
        }
    }
    private void  Buy(){
        //判断是否有票
        if(ticketNums<=0){
            flag=false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到第"+ticketNums--+"张票");
    }
}
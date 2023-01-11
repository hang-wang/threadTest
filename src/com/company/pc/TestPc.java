package com.company.pc;

//测试:生产者消费者模型---->利用缓冲区解决:管程法
//生产者，消费者，产品，缓冲区
public class TestPc {
    public static void main(String[] args) {
        SynContainer synContainer=new SynContainer();
        new Productor(synContainer).start();
        new Consumer(synContainer).start();
    }
}
//生产者
class  Productor extends Thread{
    SynContainer synContainer;
    public  Productor(SynContainer synContainer){
        this.synContainer=synContainer;
    }
    //生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synContainer.push(new Chicken(i));
            System.out.println("生产了第"+i+"只鸡");
        }
    }
}
//消费者
class Consumer extends Thread{
    SynContainer synContainer;
    public  Consumer(SynContainer synContainer){
        this.synContainer=synContainer;
    }
    //消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第"+synContainer.pop().id+"只鸡");
        }
    }
}
//产品
class Chicken{
    int id;//产品编号

    public Chicken(int id) {
        this.id = id;
    }
}
//缓冲区
class SynContainer{
    //需要一个容器大小
    Chicken[] chickens=new Chicken[10];
    //容器计数器
    int count=0;
    //生产者生产产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，就需要等待消费者消费
        while (count==chickens.length-1){
            //通知消费者消费，生产者等待
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，就丢入产品
        chickens[count]=chicken;
        count++;
        //通知消费者消费
        this.notifyAll();
    }
    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费,使用while是因为假如有多个消费者，同时在等待，使用if会直接跳出判断而使用while可以在判断一次，防止下标越界
        while(count<=0){
            //等待生产者生产，消费者等待
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Chicken chicken=chickens[count];
        //吃完了，通知生产者生产
        this.notifyAll();
        return chicken;
    }
}
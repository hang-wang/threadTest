package com.company.thread;

/**
 * JoIn 方法
 */
public class TestJoinThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程来了"+i);
        }

    }
    public static void main(String[] args) throws InterruptedException {
        TestJoinThread testJoinThread = new TestJoinThread();
        Thread thread=new Thread(testJoinThread, "a");
        thread.start();
        //主线程
        for (int i = 0; i < 300; i++) {
            if(i==200){
                thread.join();//插队
            }
            System.out.println("main " +i);
        }
    }



}
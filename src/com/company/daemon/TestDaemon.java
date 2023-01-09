package com.company.daemon;

//测试守护线程

/**
 *
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god=new God();
        You you=new You();
        Thread thread=new Thread(god);
        thread.setDaemon(true);//默认是false 表示是用户线程。正常的线程都是用户线程
        thread.start();//上帝守护线程
        new Thread(you).start();
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("god forever");
        }
    }
}
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("good bye world!");
    }
}
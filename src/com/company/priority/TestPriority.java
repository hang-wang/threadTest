package com.company.priority;

//测试线程优先级
/**
 * 优先级越高的线程，CPU越是尽量将资源给这个线程，但是并不代表优先级高，就要等着把优先级高的线程执行完了才会去执行优先级低的线程，
 * 不是这样的，只是说CPU会尽量执行高优先级线程，低优先级线程也有机会得到执行，只是机会少一些。
 * 优先级不能超出1-10的取值范围，否则抛出IllegalArgumentException。另外如果该线程已经属于一个线程组（ThreadGroup），该线程的优先级不能超过该线程组的优先级
 * 记住当线程的优先级没有指定时，所有线程都携带普通优先级。
 * 优先级可以用从1到10的范围指定。10表示最高优先级，1表示最低优先级，5是普通优先级。
 * 记住优先级最高的线程在执行时被给予优先。但是不能保证线程在启动时就进入运行状态。
 * 与在线程池中等待运行机会的线程相比，当前正在运行的线程可能总是拥有更高的优先级。
 * 由调度程序决定哪一个线程被执行。
 * t.setPriority()用来设定线程的优先级。
 * 记住在线程开始方法被调用之前，线程的优先级应该被设定。
 * 你可以使用常量，如MIN_PRIORITY,MAX_PRIORITY，NORM_PRIORITY来设定优先级。
 * Thread.setPriority()可能根本不做任何事情，这跟你的操作系统和虚拟机版本有关
 * * 线程优先级对于不同的线程调度器可能有不同的含义，可能并不是你直观的推测。特别地，优先级并不一定是指CPU的分享。在UNIX系统，优先级或多或少可以认为是CPU的分配，但Windows不是这样
 * 不要假定高优先级的线程一定先于低优先级的线程执行，不要有逻辑依赖于线程优先级，否则可能产生意外结果
 */
public class TestPriority {
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
        MyPriority myPriority=new MyPriority();
        Thread t1=new Thread(myPriority);
        Thread t2=new Thread(myPriority);
        Thread t3=new Thread(myPriority);
        Thread t4=new Thread(myPriority);
        Thread t5=new Thread(myPriority);
        Thread t6=new Thread(myPriority);
        //先设置优先级，再启动
       /* t1.start();
        t2.setPriority(1);
        t2.start();
        t3.setPriority(4);
        t3.start();
        t4.setPriority(Thread.MAX_PRIORITY);//MAX_PRIORITY=10
        t4.start();
       *//*t5.setPriority(-1);
        t5.start();
        t6.setPriority(11);
        t6.start();*//*
        t5.setPriority(6);
        t5.start();
        t6.setPriority(2);
        t6.start();*/
        t2.setPriority(1);
        t3.setPriority(4);
        t4.setPriority(Thread.MAX_PRIORITY);//MAX_PRIORITY=10
        t5.setPriority(6);
        t6.setPriority(2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

}
class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }
}
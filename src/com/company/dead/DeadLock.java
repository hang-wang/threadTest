package com.company.dead;

//死锁:多个线程互相抱着对方需要的资源,然后形成僵持
public class DeadLock {
    public static void main(String[] args) {
        MakeUp girl1=new MakeUp(0,"胡姑娘");
        MakeUp girl2=new MakeUp(1,"花姑娘");
        girl1.start();
        girl2.start();
    }
}
//口红
class LipStick{

}
//镜子
class Mirror{

}
class MakeUp extends Thread{
    //需要的资源只有一份,用static 来保证只有一份
    static LipStick lipStick=new LipStick();
    static Mirror mirror=new Mirror();
    int choice;//选择
    String girlName;//使用者
    MakeUp(int choice,String girlName){
        this.choice=choice;
        this.girlName=girlName;
    }
    //化妆,互相拿对方资源
    private void makeup() throws InterruptedException {
        if(choice==0){
            synchronized (lipStick){
                System.out.println(this.girlName+"获取口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){//1s后想获得镜子
                    System.out.println(this.girlName+"获取镜子的锁");

                }
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"获取镜子的锁");
                Thread.sleep(2000);
                synchronized (lipStick){//2s后想获得镜子
                    System.out.println(this.girlName+"获取口红的锁");

                }
            }
        }
    }
    @Override
    public void run() {
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
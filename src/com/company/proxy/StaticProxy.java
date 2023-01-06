package com.company.proxy;

/**
 * 静态代理模式总结
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实角色
 * 好处
 *      代理对象可以在做很多真实对象做不了的事
 *      真实对象只要专注自己的事情即可
 */
public class StaticProxy {

    public static void main(String[] args) {
        new WeddingCompany(new You()).HappyMarry();
        
        //推导到线程
        new Thread(()-> System.out.println("我爱你")).start();
    }
}

interface Marry{
    void HappyMarry();
}
//真实对象
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("我要结婚了，好开心");
    }
}
//代理角色，帮助结婚
class  WeddingCompany implements Marry{

    //被代理对象
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();//真实对象
        after();
    }

    private void after() {
        System.out.println("结婚后拍照");

    }

    private void before() {
        System.out.println("结婚前布置");
    }
}
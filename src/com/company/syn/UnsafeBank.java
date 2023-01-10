package com.company.syn;

import java.util.Date;

//不安全的买票
//线程不安全，有负数
//每个线程在自己的工作内存交互，内存控制不当会造成数据不一致
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");
        Drawing you = new Drawing(account, 50, "you");
        Drawing girlFriend = new Drawing(account, 100, "girlFriend");
        you.start();
        girlFriend.start();
    }
}

//账户
class Account {
    int money;//余额
    String name;//卡号

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//银行:取款
class Drawing extends Thread {
    Account account;//账户
    int drawingMoney;//取的钱
    int nowMoney;//拿在手里的钱

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.money - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + "钱不够了，无法取款");
            return;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.money = account.money - drawingMoney;
        nowMoney = nowMoney + drawingMoney;
        System.out.println(account.name + "余额为" + account.money);
        System.out.println(this.getName() + "手里有" + nowMoney);

    }
}

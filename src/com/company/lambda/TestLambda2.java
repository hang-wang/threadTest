package com.company.lambda;

/**
 * 推导lambda表达式
 */
public class TestLambda2 {
    public static void main(String[] args) {
        Ilove ilove = new Love();
        ilove.love(2);
        //1.lambda简化
        ilove = (int a) -> {
            System.out.println("i love you " + a);
        };
        ilove.love(3);
        //简化1 去掉参数类型
        ilove = (a) -> {
            System.out.println("i love you NI " + a);
        };
        ilove.love(4);
        //简化2 简化括号
        ilove = a -> {
            System.out.println("i love you NI " + a);
        };
        ilove.love(5);
        //简化3 简化大括号
        ilove = a ->System.out.println("i love you NI " + a);
        ilove.love(6);
        //总结：
        /**
         * lambda 表达式 只能有一行代码代码的情况下才能简化成为1行，如果有多行，就用代码块包裹
         * 前提是 接口必须是函数式接口(接口只能有一个方法)
         * 多个参数也可以去掉参数类型，要去掉就都去掉,必须加括号
         */
    }
}

//1.定义一个接口
interface Ilove {
    void love(int a);
}

class Love implements Ilove {

    @Override
    public void love(int a) {
        System.out.println("i LOVE YOU " + a);
    }
}
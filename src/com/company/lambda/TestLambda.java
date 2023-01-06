package com.company.lambda;

/**
 * 推导lambda表达式
 */
public class TestLambda {

    //3.静态内部类
    static class Like2 implements Ilike{
        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }
    public static void main(String[] args) {
        Ilike ilike=new Like();
        ilike.lambda();
        ilike=new Like2();
        ilike.lambda();
        //4.局部内部类
        class Like3 implements Ilike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }
        ilike=new Like3();
        ilike.lambda();

        //5.匿名内部类 没有类的名字 必须借助接口或者父类
        ilike=new Ilike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };
        ilike.lambda();
        //6.lambda简化
        ilike=()->{System.out.println("i like lambda5");};
        ilike.lambda();
    }
}

//1.定义一个接口
interface Ilike{
    void lambda();
}
//2.实现类
class Like implements Ilike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
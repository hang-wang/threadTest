package com.company.thread2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式3:实现Callable接口
/*
    Callable好处
    1.可以定义返回值
    2.可以抛出异常
 */
public class TestCallable implements Callable<Boolean> {
    private  String url;//网络图片地址
    private  String name;//保存的文件名
    public TestCallable(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名:"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1=new TestCallable("https://www.kuangstudy.com/uploadimg/course/2022-10-19/1032438546595713024.jpg","static/11.jpg");
        TestCallable t2=new TestCallable("https://www.kuangstudy.com/uploadimg/course/2022-10-21/1032816657938124800.jpg","static/21.jpg");
        TestCallable t3=new TestCallable("https://www.kuangstudy.com/uploadimg/course/2022-10-21/1033133524816891904.jpg","static/31.jpg");
        //创建执行服务
        ExecutorService service= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1=service.submit(t1);
        Future<Boolean> r2=service.submit(t2);
        Future<Boolean> r3=service.submit(t3);
        //获取结果
        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();
        //关闭服务
        service.shutdownNow();
    }
}
//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法出现异常");
        }
    }
}
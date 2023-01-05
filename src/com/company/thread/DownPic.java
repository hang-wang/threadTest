package com.company.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DownPic extends  Thread{
    private  String url;//网络图片地址
    private  String name;//保存的文件名
    public DownPic(String url,String name){
        this.url=url;
        this.name=name;
    }

    @Override
    public void run() {
       WebDownloader webDownloader=new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名:"+name);
    }

    public static void main(String[] args) {
        DownPic t1=new DownPic("https://www.kuangstudy.com/uploadimg/course/2022-10-19/1032438546595713024.jpg","static/1.jpg");
        DownPic t2=new DownPic("https://www.kuangstudy.com/uploadimg/course/2022-10-21/1032816657938124800.jpg","static/2.jpg");
        DownPic t3=new DownPic("https://www.kuangstudy.com/uploadimg/course/2022-10-21/1033133524816891904.jpg","static/3.jpg");
        t1.start();
        t2.start();
        t3.start();

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
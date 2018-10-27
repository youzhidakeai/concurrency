package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-10-27
 * Time: 下午7:47
 */
@Slf4j
public class SynchronizedExceple2 {

    //修饰一个类的使用
    public static void test1(int j){
        synchronized (SynchronizedExceple2.class){
            for (int i=0;i<10;i++){
                log.info("test1-{}-{}",j,i);
            }
        }
    }

    //修饰一个静态方法的使用
    public static synchronized void test2(int j){
        for (int i=0;i<10;i++){
            log.info("test2-{}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExceple2 exceple1 = new SynchronizedExceple2();
        SynchronizedExceple2 exceple2 = new SynchronizedExceple2();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            exceple1.test1(1);
        });
        executorService.execute(()->{
            exceple2.test1(2);
        });
    }



}

package com.mmall.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
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
public class SynchronizedExceple1 {

    //修饰一个代码块
    public void test1(int j){
        synchronized (this){
            for (int i=0;i<10;i++){
                log.info("test1-{}-{}",j,i);
            }
        }
    }

    //修饰一个方法的使用
    public synchronized void test2(int j){
        for (int i=0;i<10;i++){
            log.info("test2-{}-{}",j,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExceple1 exceple1 = new SynchronizedExceple1();
        SynchronizedExceple1 exceple2 = new SynchronizedExceple1();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            exceple1.test2(1);
        });
        executorService.execute(()->{
            exceple2.test2(2);
        });
    }




}

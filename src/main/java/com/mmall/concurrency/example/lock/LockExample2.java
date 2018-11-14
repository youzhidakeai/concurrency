package com.mmall.concurrency.example.lock;

import com.mmall.concurrency.annoations.Recommend;
import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-14
 * Time: 上午9:57
 */
@Slf4j
@ThreadSafe
public class LockExample2 {

    public static int clientTotal = 5000;//请求中数

    public static int threadTotal = 200;//同时并发执程总数

    public static int count = 0;

    private final static Lock lock = new ReentrantLock();


    //模拟并发执行
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("interruptedException",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count);
    }

    //计数方法
    private static void add(){
        lock.lock();
        try {
            count++;
        }finally {
            lock.unlock();
        }

    }
}

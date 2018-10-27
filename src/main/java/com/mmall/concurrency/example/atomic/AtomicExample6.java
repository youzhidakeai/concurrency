package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.NotRecommend;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-10-27
 * Time: 上午10:02
 */
@Slf4j
@NotRecommend
public class AtomicExample6 {

    private static AtomicBoolean isHappend = new AtomicBoolean(false);

    public static int clientTotal = 5000;//请求中数

    public static int threadTotal = 200;//同时并发执程总数

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i=0;i<clientTotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("interruptedException",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",isHappend.get());

    }

    private static void test(){
        if (isHappend.compareAndSet(false, true)) {

            log.info("execute");
        }
    }
}

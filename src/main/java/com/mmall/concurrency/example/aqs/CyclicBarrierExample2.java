package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description: code change world
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-14
 * Time: 下午9:25
 */
@Slf4j
public class CyclicBarrierExample2 {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0;i < 10; i++){
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() ->{
                try {
                    race(threadNum);
                }catch (Exception e){
                    log.info("exception",e);
                }

            });
        }
        executorService.shutdown();
    }

    private static void race(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        try {
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        }catch (BrokenBarrierException | TimeoutException e){
            log.error("BarrierException",e);
        }
        log.info("{} continue",threadNum);
    }
}

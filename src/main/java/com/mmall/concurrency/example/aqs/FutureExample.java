package com.mmall.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * Description: code change world
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-15
 * Time: 下午8:38
 */
@Slf4j
public class FutureExample {

    static class MyCallable implements Callable<String> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public String call() throws Exception {
            log.info("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String>future = exec.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        String result = future.get();
        log.info("result:{}", result);
    }
}

package com.mmall.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description: code change world
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-15
 * Time: 下午10:15
 */
@Slf4j
public class ThreadPoolExample3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0 ;i < 10; i++){
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                log.info("task:{}",index);
                }
            });
        }
        executorService.shutdown();
    }
}

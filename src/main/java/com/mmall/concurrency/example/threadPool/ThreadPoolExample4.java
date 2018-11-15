package com.mmall.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description: code change world
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-15
 * Time: 下午10:15
 */
@Slf4j
public class ThreadPoolExample4 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
//        executorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                log.warn("scheduled run");
//            }
//        },3, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                log.warn("scheduled run");
            }
        },1,3,TimeUnit.SECONDS);
//        executorService.shutdown();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        },new Date(),5*1000);
    }
}

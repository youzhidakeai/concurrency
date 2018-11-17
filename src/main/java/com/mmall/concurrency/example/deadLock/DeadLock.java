package com.mmall.concurrency.example.deadLock;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA.
 * Description: code change world
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-17
 * Time: 下午3:48
 */
@Slf4j
public class DeadLock implements Runnable{

    public int flag = 1;

    //静态对象是类的所有对象共享的
    private static Object o1 = new Object(),o2 = new Object();

    @Override
    public void run(){
        log.info("flag:{}",flag);
        if (flag == 1){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (o2){
                    log.info("1");
                }
            }
        }
        if (flag == 0){
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    log.info("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock td1 = new DeadLock();
        DeadLock td2 = new DeadLock();
        td1.flag = 1;
        td2.flag = 0;

        //td1,td2都处于可执行状态，但JVM线程调度先执行那个线程是不确定的
        //td2的run()可能处在td1的run()之前运行
        new Thread(td1).start();
        new Thread(td2).start();
    }
}

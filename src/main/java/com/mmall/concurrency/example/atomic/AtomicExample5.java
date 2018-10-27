package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.NotRecommend;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.naming.ldap.PagedResultsControl;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

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
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class,"count");

    @Getter
    public volatile int count = 100;

    private static AtomicExample5 atomicExample5 = new AtomicExample5();

    public static void main(String[] args) {
        if (updater.compareAndSet(atomicExample5,100,120)){
            log.info("update success,{}",atomicExample5.getCount());
        }
        if (updater.compareAndSet(atomicExample5,100,120)){
            log.info("update success,{}",atomicExample5.getCount());
        }else {
            log.error("update error{}",atomicExample5.getCount());
        }


    }
}

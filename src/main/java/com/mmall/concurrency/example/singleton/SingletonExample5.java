package com.mmall.concurrency.example.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-12
 * Time: 下午4:14
 */

import com.mmall.concurrency.annoations.NotRecommend;
import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式 --> 双重同步锁单例模式
 * 单例实例在第一次使用时候进行创建
 */
@ThreadSafe
public class SingletonExample5 {

    //私有的构造函数
    private SingletonExample5(){}

    // 1.memory = allocate() 分配对象的内存空间
    // 2.ctorInstance() 初始化对象
    // 3. instance = memory 设置instance 指向刚分配的内存

    //单例对象 volatitle+ 双重检测机制 -> 禁止指令重排序
    private volatile static SingletonExample5 instance = null;

    //静态的工厂方法
    private static SingletonExample5 getInstance(){
        if (instance == null){ //双重检测机制          //B
            synchronized (SingletonExample5.class){ //同步锁
                if (instance == null){
                    instance = new SingletonExample5(); //A - 3
                }
            }
        }
        return instance;
    }
}

package com.mmall.concurrency.example.singleton;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-12
 * Time: 下午4:14
 */

import com.mmall.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在装载使用时候进行创建
 */
@ThreadSafe
public class SingletonExample2 {

    //私有的构造函数
    private SingletonExample2(){}

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态的工厂方法
    private static SingletonExample2 getInstance(){
        return instance;
    }
}

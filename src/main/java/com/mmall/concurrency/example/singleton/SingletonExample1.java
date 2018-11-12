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

/**
 * 懒汉模式
 * 单例实例在第一次使用时候进行创建
 */
@NotRecommend
public class SingletonExample1 {

    //私有的构造函数
    private SingletonExample1(){}

    //单例对象
    private static SingletonExample1 instance = null;

    //静态的工厂方法
    private static SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}

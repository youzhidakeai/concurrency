package com.mmall.concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-10-26
 * Time: 下午11:57
 */

/**
 * 课程里用来标记线程安全的类或者写法
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";

}

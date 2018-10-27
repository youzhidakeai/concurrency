package com.mmall.concurrency.mq.kafka;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-10-27
 * Time: 下午10:45
 */
@Data
public class Message {
    private Long id;

    private String msg;

    private Date sendTime;
}

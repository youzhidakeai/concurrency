package com.mmall.concurrency.mq.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-10-27
 * Time: 下午10:31
 */
@Component
@Slf4j
public class KafkaSender {

    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    public void send(String msg){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(msg);
        message.setSendTime(new Date());
        log.info("send message:{}",message);
        kafkaTemplate.send(TopicConstants.TEST,gson.toJson(message));
    }
}

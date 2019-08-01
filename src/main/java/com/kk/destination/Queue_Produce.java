package com.kk.destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

/**
 * @Auther: Administrator
 * @Date: 2019/7/20 16:03
 * @Description:
 */
//@Component
public class Queue_Produce {

    @Autowired
    private JmsMessagingTemplate jmt;

    @Autowired
    private Queue queue;

    public void produceMsg(){
        jmt.convertAndSend(queue,"---"+ UUID.randomUUID().toString().substring(0,6));
    }

    //间隔3秒钟定投
    @Scheduled(fixedDelay = 3000)
    public void produceMsgScheduled(){
        produceMsg();
        System.out.println("Scheduled send ok!");
    }

}

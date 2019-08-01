package com.kk.destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.TextMessage;
import java.util.UUID;

/**
 * @Auther: Administrator
 * @Date: 2019/7/20 16:03
 * @Description:
 */
//@Component
public class Queue_Consumer {

    @JmsListener(destination = "${myqueue}")
    public void receive(TextMessage textMessage)throws JMSException {
        System.out.println("---消费者收到消息:"+textMessage.getText());
    }
}

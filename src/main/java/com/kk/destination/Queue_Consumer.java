package com.kk.destination;

import org.springframework.jms.annotation.JmsListener;

import javax.jms.JMSException;
import javax.jms.TextMessage;

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

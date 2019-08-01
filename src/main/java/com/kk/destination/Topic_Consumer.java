package com.kk.destination;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * @Auther: Administrator
 * @Date: 2019/7/20 16:03
 * @Description:
 */
//@Component
public class Topic_Consumer {

    @JmsListener(destination = "${mytopic}")
    public void receive(TextMessage textMessage){
        try {
            System.out.println("---消费者收到订阅的消息7777:"+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

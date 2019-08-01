package com.kk.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Auther: Administrator
 * @Date: 2019/7/20 15:59
 * @Description:
 */
@Configuration
@EnableJms
public class MqConfig {

    @Value("${myqueue}")
    private String myQueue;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueue);
    }

    @Value("${mytopic}")
    private String myTopic;

    @Bean
    public Topic topic(){return new ActiveMQTopic(myTopic); }

}

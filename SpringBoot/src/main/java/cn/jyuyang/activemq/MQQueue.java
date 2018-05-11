package cn.jyuyang.activemq;

import cn.jyuyang.entity.User;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;
@Component
public class MQQueue {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessageToQueue(String message){
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("queue");
        jmsTemplate.send(activeMQQueue,session -> {
            TextMessage textMessage = session.createTextMessage(message);

            return textMessage;

        });
    }

    //发送对象

    public void sendUserToQueue(){
        User user = new User();
        user.setId(66);
        user.setName("tom");
        ActiveMQQueue activeMQQueue = new ActiveMQQueue("queue");
        jmsTemplate.convertAndSend(activeMQQueue,user);
    }
}


package cn.jyuyang.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.TextMessage;

@Component
public class MQTopic {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessageToQueue(String message){
        ActiveMQTopic activeMQQueue = new ActiveMQTopic("topic");
        jmsTemplate.send(activeMQQueue,session -> {
            TextMessage textMessage = session.createTextMessage(message);
            return textMessage;

        });
    }
}


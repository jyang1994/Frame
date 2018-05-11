package cn.jyuyang.activemq;

import cn.jyuyang.entity.User;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MyJmsListener {

    @JmsListener(destination = "topic")
    public void getMessage(User user){
        System.out.println(user+"------user");
    }

    @JmsListener(destination = "queue")
    public void hello(Message message){
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("message:---"+textMessage.getText());

            textMessage.acknowledge();

        } catch (JMSException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("namecuowu-------");
    }

    //配置主题监听器
    @JmsListener(destination = "topic",containerFactory = "topicFactory")
    public void topicListener(String message){
        System.out.println("topic:"+message);
    }
}

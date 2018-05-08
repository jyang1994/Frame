package cn.jyuyang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@Component
public class SpringJMSqueueTest {

    @Autowired
    private Destination destination;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    @JmsListener(destination = "weixin-queue")
    public void getSub(String message) throws IOException {
        System.out.println("<<<<<<<<<<<<< " + message);
        System.in.read();
    }


   /* @Test
    public void getSub() throws IOException {
        jmsTemplate.send(destination,new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("sping-mq");
            }
        });
        System.in.read();
    }*/
}

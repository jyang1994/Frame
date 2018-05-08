package cn.jyuyang;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;
import java.io.IOException;

public class PubSubTest {
    @Test
    public void createPub() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("weixin-topic");
        MessageProducer producer = session.createProducer(topic);

        TextMessage textMessage =  session.createTextMessage("heelo,topic");
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();
    }


    @Test
    public void getSub() throws JMSException, IOException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("weixin-topic");

        MessageConsumer consumer = session.createConsumer(topic);

        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());

                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.in.read();

        consumer.close();
        session.close();
        connection.close();

    }
}

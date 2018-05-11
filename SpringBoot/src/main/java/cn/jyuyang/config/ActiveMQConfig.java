package cn.jyuyang.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
@Configuration
@EnableJms
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokeUrl;

    //开启主题发布、订阅模式
    @Bean
    public JmsListenerContainerFactory topicFactory (
            ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory,connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {

        RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
        redeliveryPolicy.setMaximumRedeliveries(3);
        redeliveryPolicy.setInitialRedeliveryDelay(3000);
        redeliveryPolicy.setRedeliveryDelay(3000);
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();

        activeMQConnectionFactory.setRedeliveryPolicy(redeliveryPolicy);
        activeMQConnectionFactory.setBrokerURL(brokeUrl);
        return activeMQConnectionFactory;
    }

    /**
     * 传送对象转换器
     * @return
     */
    @Bean
    public MessageConverter jacksonMessageConverter(){
        MappingJackson2MessageConverter jackson2MessageConverter = new MappingJackson2MessageConverter();
        jackson2MessageConverter.setTargetType(MessageType.TEXT);
        jackson2MessageConverter.setEncodingPropertyName("_type");
        return jackson2MessageConverter;
    }
}

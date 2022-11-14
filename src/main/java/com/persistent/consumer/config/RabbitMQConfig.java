package com.persistent.consumer.config;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLContextSpi;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.persistent.consumer.service.RabbitMQConsumer;
@Configuration
public class RabbitMQConfig {

	@Value("${payment.rabbitmq.queue}")
	String queueName;
	
	@Value("${spring.rabbitmq.username}")
	String username;

	@Value("${spring.rabbitmq.password}")
	private String password;
	
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}
	
	@Bean
	MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
		SimpleMessageListenerContainer simpleListenerContainer = new SimpleMessageListenerContainer();
		
		simpleListenerContainer.setConnectionFactory(connectionFactory);
		simpleListenerContainer.setQueues(queue());
		simpleListenerContainer.setMessageListener(new RabbitMQConsumer());
		System.out.println("Consumer queueName ::"+queueName);
		System.out.println("simpleListenerContainer ::"+simpleListenerContainer.getActiveConsumerCount());
		System.out.println("simpleListenerContainer --->::"+simpleListenerContainer.toString());
		
		return simpleListenerContainer;
	}
}

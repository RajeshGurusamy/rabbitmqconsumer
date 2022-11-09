package com.persistent.consumer.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer implements MessageListener{

	@Override
	public void onMessage(Message message) {
		System.out.println("Consume messages - "+ new String(message.getBody()));
		
	}

}

package com.kafka.test.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.kafka.test.consumer.service.KafkaConsumerServiceImpl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class KafkaTestListener {

	private final @NonNull KafkaConsumerServiceImpl kafkaConsumerService;

	@KafkaListener(topics = {"topic-test"}, groupId = "group")
	public void listenTopicTest(@Payload String message,
			@Header(KafkaHeaders.GROUP_ID) String groupId) {
		kafkaConsumerService.messageConsumed(message);
	}

}

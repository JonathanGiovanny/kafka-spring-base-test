package com.kafka.test.producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaServiceImpl {

	private final @NonNull KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topicName, String msg) {
		log.info("Sending message to Kafka topic: {} + Message: {}", topicName, msg);
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, msg);
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	        @Override
	        public void onSuccess(SendResult<String, String> result) {
	            log.info("Sent message=[{}] with offset=[{}]", msg,
	            		result.getRecordMetadata().offset());
	        }
	        @Override
	        public void onFailure(Throwable ex) {
	            log.error("Unable to send message=[{}] due to : {}", msg, ex.getMessage(), ex);
	        }
	    });
	}

}

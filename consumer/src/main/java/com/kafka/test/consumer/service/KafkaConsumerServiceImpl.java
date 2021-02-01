package com.kafka.test.consumer.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumerServiceImpl {

	public void messageConsumed(String message) {
		log.info("A message has been consumed: {}", message);
	}
}

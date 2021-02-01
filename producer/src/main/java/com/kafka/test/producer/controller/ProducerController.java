package com.kafka.test.producer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.test.producer.service.KafkaServiceImpl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("producer")
@RequiredArgsConstructor
public class ProducerController {

	private final @NonNull KafkaServiceImpl kafkaService;

	@PostMapping("send/{topic}")
	public void sendMessage(@PathVariable String topic, @RequestParam String message) {
		kafkaService.sendMessage(topic, message);
	}

}

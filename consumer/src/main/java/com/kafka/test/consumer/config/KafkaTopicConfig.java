package com.kafka.test.consumer.config;

import java.util.Collections;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

	@Bean
	KafkaAdmin kafkaAdmin() {
		String key = AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG;
		String value = "localhost:9092";
		return new KafkaAdmin(Collections.singletonMap(key, value));
	}

	@Bean
	NewTopic topic1() {
		return new NewTopic("topic-test", 1, Short.parseShort("1"));
	}

}

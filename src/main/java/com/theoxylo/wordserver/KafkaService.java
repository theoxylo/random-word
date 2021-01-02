package com.theoxylo.wordserver;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
	
	Logger log = LoggerFactory.getLogger(KafkaService.class);
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	void send(String message) {
		log.info("Sending message: " + message);
		
		String topic = "quickstart-events";
		kafkaTemplate.send(topic, message);
	}
	
    @KafkaListener(topics = "quickstart-events", groupId = "group_id")
    public void consume(String message) throws IOException {
    	log.info("Received message: " + message);
    }

}

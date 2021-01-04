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
	KafkaTemplate<String, Word> kafkaTemplate;

	void send(Word word) {
		log.info("Sending word: " + word);
		String topic = "quickstart-events";
		kafkaTemplate.send(topic, word);
	}

	@KafkaListener(topics = "quickstart-events", groupId = "group_id")
	public void consume(Word word) throws IOException {
		log.info("Received word: " + word);
	}

}

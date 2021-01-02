package com.theoxylo.wordserver;

import java.util.List;
import java.util.Collection;
import java.util.*;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.theoxylo.wordserver.KafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WordService {
	
	Logger log = LoggerFactory.getLogger(WordService.class);

	@Autowired
	private WordRepository _wordRepo;
	
	@Autowired
	private KafkaService kafkaService;

	public Word getRandomWord() {
		log.info("get random word");
		// return _wordRepo.getRandomWord();
		return new Word("testing");
		// return _wordRepo.findOne("test");
	}

	public Word createWord(Word word) {
		log.info("service create word called: " + word);
		//word.setId(UUID.randomUUID().toString());
		//kafkaService.send("Creating word: " + word.toString());
		Word result = _wordRepo.save(word);
		kafkaService.send("Created word: " + result.toString());
		return result;
	}

	public List<Word> getAllWords() {
		Iterable<Word> words = _wordRepo.findAll();
		Iterator<Word> it = words.iterator();
		List<Word> list = new ArrayList<Word>();
		while (it.hasNext()) {
			list.add(it.next());
		}		
		kafkaService.send(words.toString());
		log.info("all words: " + words);
		return list;
	}

}

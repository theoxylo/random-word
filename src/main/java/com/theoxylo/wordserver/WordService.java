package com.theoxylo.wordserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import org.springframework.stereotype.Service;

import com.theoxylo.wordserver.KafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Service
public class WordService {
	
	Logger log = LoggerFactory.getLogger(WordService.class);

	@Autowired
	private WordRepository _wordRepo;
	
	@Autowired
	private KafkaService kafkaService;

	public Word getRandomWordFromRepoNotUsed() {
		log.info("get random word");
		//return _wordRepo.getRandomWord();
		return new Word("testing");
	}
	
	public Word getWord(Integer id) {
		Optional<Word> word = _wordRepo.findById(id);
		if (word.isPresent()) return word.get();
		return null;
	}
	
	public Word createWord(Word word) {
		log.info("service create word called: " + word);
		log.info("definition data: " + word.getDefinitions());
		Word result = _wordRepo.save(word);
		kafkaService.send(word);
		return result;
	}

	public List<Word> getAllWords() {
		Iterable<Word> words = _wordRepo.findAll();
		Iterator<Word> it = words.iterator();
		List<Word> list = new ArrayList<Word>();
		while (it.hasNext()) {
			Word word = it.next();
			//kafkaService.send(word);
			list.add(word);
		}		
		log.info("all words: " + words);
		return list;
	}
	
	public Word getRandomWord() {
		List<Word> words = getAllWords();
		int randomIndex = new Random().nextInt(words.size());
		Word result = words.get(randomIndex);	
		kafkaService.send(result);
		return result;
	}
	
	public Word getRandomWordFromFile() {
        List<String> _words = new ArrayList<String>();
		try {
            String _wordsFile = "words_alpha.txt";
			Resource resource = new ClassPathResource(_wordsFile);
			BufferedReader in = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			while (in.ready()) {
				String word = in.readLine();
				_words.add(word);
			}
			log.info("word count: " + _words.size());
		}
		catch (IOException e) {
			log.error(e.getMessage());
		}
		int randomIndex = new Random().nextInt(_words.size());
		Word result = new Word(_words.get(randomIndex));	
		kafkaService.send(result);
		return result;
	}

}

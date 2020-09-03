package com.theoxylo.wordserver;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WordService {
    
    @Autowired
    private WordRepository _wordRepo;
    
    public Word getRandomWord() {
        System.out.println("get random word");
	return _wordRepo.getRandomWord();
    }

    public Word createWord(Word word) {
        System.out.println("service create word called");
	return _wordRepo.createWord(word);
    }
}

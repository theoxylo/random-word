package com.theoxylo.wordserver;

import java.util.List;
import java.util.Collection;
import java.util.*;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WordService {
    
    @Autowired
    private WordRepository _wordRepo;
    
    public Word getRandomWord() {
        System.out.println("get random word");
	//return _wordRepo.getRandomWord();
	return new Word("testing");
	//return _wordRepo.findOne("test");
    }

    public Word createWord(Word word) {
        System.out.println("service create word called: " + word);
	word.setId(UUID.randomUUID().toString());
	return _wordRepo.save(word);
    }

    public List<Word> getAllWords() {
	    //return Collection.asList(_wordRepo.findAll());
	    Iterable<Word> words = _wordRepo.findAll();
	    Iterator<Word> it = words.iterator();
	    List<Word> list = new ArrayList<Word>();
	    while (it.hasNext()) {
		    list.add(it.next());
	    }
	    System.out.println("all words: " + words);
	    return list;
    }

}

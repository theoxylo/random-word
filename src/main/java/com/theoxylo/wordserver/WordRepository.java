package com.theoxylo.wordserver;

import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Integer> {
	//public Word getRandomWord();
	//public Word createWord(Word word);
}

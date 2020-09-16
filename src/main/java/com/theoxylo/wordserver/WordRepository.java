package com.theoxylo.wordserver;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, String> {
	//public Word getRandomWord();
	//public Word createWord(Word word);
}

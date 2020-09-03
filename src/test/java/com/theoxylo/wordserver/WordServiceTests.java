package com.theoxylo.wordserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
class WordServiceTests {

	@Test
	void allWordsLoadedFromFile() {
		WordService svc = new WordService();
		assert(svc.getRandomWord() != null);
		//int wordCount = svc.getWordCount();
		//assert(wordCount == 6);
	}
}


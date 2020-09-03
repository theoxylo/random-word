package com.theoxylo.wordserver;

import java.util.*;

public interface WordRepository {
	public Word getRandomWord();
	public Word createWord(Word word);
}

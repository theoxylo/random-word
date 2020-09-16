package com.theoxylo.wordserver;

import org.springframework.stereotype.Repository;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class WordRepositoryTestImpl implements WordRepository {

    private List<String> _words;
    private Random _indexGenerator;

    @Value("${words.filename}")
    private String _wordsFile;
    
    @Override
    public Word createWord(Word word) {
	if (_words == null ||_words.size() == 0) loadWords();
	_words.add(word.getWord());
	System.out.println("new word count: " + _words.size());
	return word;
    }

	@Override
	public Word getRandomWord() {
		//	return new Word("testing");
		if (_words == null ||_words.size() == 0) loadWords();
		int randomIndex = _indexGenerator.nextInt(_words.size());
		return new Word(_words.get(randomIndex));
	}

    private void loadWords() {
        _indexGenerator = new Random();
        _words = new ArrayList<String>();
		try {
            System.out.println("words file: " + _wordsFile);
            if (_wordsFile == null) _wordsFile = "words_alpha.txt";
			Resource resource = new ClassPathResource(_wordsFile);
			BufferedReader in = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			while (in.ready()) {
				_words.add(in.readLine());
			}
			System.out.println("word count: " + _words.size());
		}
		catch (IOException e) {
			System.out.println(e);
		}
    }
}

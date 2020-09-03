package com.theoxylo.wordserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value="api")
public class WordController {

	@Autowired 
	private WordService wordService;

	@GetMapping(value="/word")
	public ResponseEntity<Word> getRandomWord() {
		//Word word = wordService.getRandomWord();
		Word word = wordService.getRandomWord();
		return ResponseEntity.ok(word);
	}

	@PostMapping(value="/word")
	public ResponseEntity<Word> createWord(@RequestBody Word word) {
		System.out.println("word: " + word);
		wordService.createWord(word);
		return ResponseEntity.ok(word);
	}

	@PostMapping(value="/wordtest")
	public Word createWordTest(@RequestBody Word word) {
		wordService.createWord(word);
		return word;
	}

}

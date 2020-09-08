package com.theoxylo.wordserver;

import javax.validation.*;

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

	@GetMapping(value="/wordx")
	public Word getRandomWordTest() {
		Word word = wordService.getRandomWord();
		//return ResponseEntity.ok(word);
		return word; // return simple entity object without wrapper
	}

	@GetMapping(value="/word/{word}/length")
	public ResponseEntity<Integer> getWordLength(@PathVariable String word) {
	//public Integer getWordLength(@PathVariable String word) {
		//Word word = wordService.getRandomWord();
		//Word word = wordService.getRandomWord();
		return ResponseEntity.ok(word.length());
		//return new Integer(word.length());
	}

	@PostMapping(value="/word")
	public ResponseEntity<Word> createWord(@Valid @RequestBody Word word) {
		System.out.println("word: " + word);
		wordService.createWord(word);
		return ResponseEntity.ok(word);
	}

}

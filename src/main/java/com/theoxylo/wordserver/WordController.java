package com.theoxylo.wordserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value="/api")
public class WordController {

	@Autowired 
	private WordService wordService;

	@Autowired
	private Properties props;

	@GetMapping(value="/date")
	public ResponseEntity<Date> getDate() {
		//return new ResponseEntity<String>("time: " + new Date(), HttpStatus.OK);
		return new ResponseEntity<Date>(new Date(), HttpStatus.OK);
	}

	@GetMapping(value="/word")
	public ResponseEntity<Word> getRandomWord() {
		System.out.println("greeting from controller: " + props.greeting);
		Word word = wordService.getRandomWord();
		//return ResponseEntity.ok(word);
		return new ResponseEntity<>(word, HttpStatus.OK);
	}

	@GetMapping(value="/wordx")
	public Word getRandomWordTest() {
		Word word = wordService.getRandomWordFromFile();
		//return ResponseEntity.ok(word);
		return word; // return simple entity object without wrapper
	}

	@GetMapping(value="/words")
	public ResponseEntity<List<Word>> getAllWords() {
		return ResponseEntity.ok(wordService.getAllWords());
	}

	@GetMapping(value="/wordsx")
	public Iterable<Word> getAllWordsIterable() {
		return wordService.getAllWords();
	}

	@GetMapping(value="/word/{word}/length")
	public ResponseEntity<Integer> getWordLength(@PathVariable String word) {
	//public Integer getWordLength(@PathVariable String word) {
		return ResponseEntity.ok(Integer.valueOf(word.length()));
		//return new Integer(word.length());		
	}

	@GetMapping(value="/word/{word}/info")
	public ResponseEntity<Word> getWordInfo(@PathVariable String word) {
		return ResponseEntity.ok(new Word(word));
	}

	@GetMapping(value="/word/{id}")
	public ResponseEntity<Word> getWordDetails(@PathVariable Integer id) {
		//return ResponseEntity.ok(wordService.getWord(id));
		
		Word result = wordService.getWord(id);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping(value="/word")
	public ResponseEntity<Word> createWord(@Valid @RequestBody Word word) {
		System.out.println("word: " + word);
		wordService.createWord(word);
		//return ResponseEntity.ok(word);
		return new ResponseEntity<>(word, HttpStatus.CREATED);
	}

}

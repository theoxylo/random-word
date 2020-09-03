package com.theoxylo.wordserver;

public class Word {
    
    String word;

    public Word() {
    }

    public Word(String s) {
        word = s;
    }
    
    public String getWord() {
        return word;
    }

    public void setWord(String s) {
	    word = s;
    }

    /*
    public int getLength() {
        return word.length();
    }
    */
}

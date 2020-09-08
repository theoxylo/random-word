package com.theoxylo.wordserver;

import javax.validation.constraints.NotBlank;

public class Word {
    
    @NotBlank(message = "blank word not allowed")
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

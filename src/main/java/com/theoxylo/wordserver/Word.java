package com.theoxylo.wordserver;

import javax.validation.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Word {
    
    @NotBlank(message = "blank word not allowed")
    String word;

    @Id
    String id;
    
    String definition;

    public Word() {
    }

    public Word(String s) {
        word = s;
    }
    
    public String getId() { return id; }

    public void setId(String s) { id = s; }

    public String getWord() { return word; }

    public void setWord(String s) { word = s; }

    public String getDefinition() { return definition; }
    
    public void setDefinition(String s) { definition = s; }

    public String toString() { return word; }

    public int getLength() {
        return word.length();
    }
}

package com.theoxylo.wordserver;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Word {
    
    String word;

    @Id
    String id;
    
    String definition;

    public Word() {
    }

    public Word(String s) {
        word = s;
    }
    
    public String toString() { return word; }

    public int getLength() {
        return word.length();
    }
}

package com.theoxylo.wordserver;

import lombok.Data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Word {
    
    String text;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "WORD_ID", referencedColumnName = "ID")
    //@JsonIgnore
    List<Definition> definitions;

    public Word() {
    }

    public Word(String s) {
        text = s;
    }
    
    public String toString() { 
    	return text; 
    }

    public int getLength() {
        return text.length();
    }
}

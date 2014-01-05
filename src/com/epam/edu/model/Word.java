package com.epam.edu.model;

public class Word implements SentenceElement {
	
	private String word;

	public Word(String word) {
		setWord(word);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		if (word == null) throw new IllegalArgumentException();
		this.word = word;
	}

	@Override
	public String toString() {
		return word;
	}
	
}

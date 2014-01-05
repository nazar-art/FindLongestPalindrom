package com.epam.edu.model;

import java.util.ArrayList;

public class Text {

	private ArrayList<Sentence> text;

	public Text() {
		text = new ArrayList<Sentence>();
	}
	
	public void addSentence(String sentence) {
		text.add(new Sentence(sentence));
	}

	public ArrayList<Sentence> getText() {
		return text;
	}

	@Override
	public String toString() {
		return text.toString();
	}
	
}

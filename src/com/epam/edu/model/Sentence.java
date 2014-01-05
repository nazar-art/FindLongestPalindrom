package com.epam.edu.model;

import java.util.LinkedList;

public class Sentence {

	public String sentence;
	private LinkedList<SentenceElement> elements;

	/**
	 * Constructs a sentence.
	 * @param aText a string containing all characters of the sentence
	 */
	public Sentence(String aText) {
		elements = new LinkedList<>();
		sentence = aText.trim();
		splitSentence();
	}
	
	public String getSentence() {
		return sentence;
	}

	public LinkedList<SentenceElement> getElements() {
		return elements;
	}

	/**
	 * Split sentance into words and punctuations
	 */
	private void splitSentence() {
		if (sentence.equals("") || sentence.equals(null) || sentence.equals("\n")) {
			return;
		}
		
		String[] parts = sentence.split("(?<!^)\\b");
		for (int i = 0; i < parts.length; i++) {
			String current = parts[i];
			if (isWord(current)) {
				elements.add(new Word(current.trim()));
			} else {
				elements.add(new Punctuation(current));
			}
		}
	}
	
	/**
	 * Check if current word contatin letters
	 * @param word for checking
	 * @return true whether this is word false otherwise 
	 */
	private boolean isWord(String word) {
		boolean result = false;
		
		for (int i = 0; i < word.length(); i++) {
			if (Character.isLetter(word.charAt(i))) return true;
		}
		
		return result;
	}

	/**
	 * Tests whether this sentence is a palindrome.
	 * @return true if this sentence is a palindrome, false otherwise
	 */
	@SuppressWarnings("unused")
	private boolean isPalindrome() {
		int start = 0;
		int end = sentence.length() - 1;

		while (start < end) {
			char first = Character.toLowerCase(sentence.charAt(start));
			char last = Character.toLowerCase(sentence.charAt(end));

			if (Character.isLetter(first) && Character.isLetter(last)) {
				// Both are letters.
				if (first == last) {
					start++;
					end--;
				} else {
					return false;
				}
			}

			if (!Character.isLetter(last)) {
				end--;
			}
			if (!Character.isLetter(first)) {
				start++;
			}
		}
		return true;
	}
	
	public boolean isPalindrome(String checkText) {
		int start = 0;
		int end = checkText.length() - 1;

		while (start < end) {
			char first = Character.toLowerCase(checkText.charAt(start));
			char last = Character.toLowerCase(checkText.charAt(end));

			if (Character.isLetter(first) && Character.isLetter(last)) {
				// Both are letters.
				if (first == last) {
					start++;
					end--;
				} else {
					return false;
				}
			}

			if (!Character.isLetter(last)) {
				end--;
			}
			if (!Character.isLetter(first)) {
				start++;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return sentence;
	}
	
}

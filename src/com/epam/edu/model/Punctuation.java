package com.epam.edu.model;

public class Punctuation implements SentenceElement {

    private String punctuationMark;

    public Punctuation(String symbol) {
        setPunctuation(symbol);
    }

    public String getPunctuation() {
        return punctuationMark;
    }

    public void setPunctuation(String symbol) {
        punctuationMark = symbol;
    }

    @Override
    public String toString() {
        return punctuationMark;
    }

}

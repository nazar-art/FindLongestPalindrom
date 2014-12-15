package com.epam.edu.controller;

import com.epam.edu.model.Reader;
import com.epam.edu.model.Sentence;
import com.epam.edu.model.Text;
import com.epam.edu.view.Files;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Splitter {

    private static final String SPLITTER_INTO_SENTENCES = "((.+[\\.|\\?|\\.|\\:|\\!])|.+((\\.)\"))";
    // ((.+[\.|\?|\.|\:|\!])|.+((\.)"))

    private Text text = new Text();

    Map<Integer, Sentence> palindromMap = new TreeMap<Integer, Sentence>();

    private StringTokenizer tokenizer;

    public Splitter(String fileContent) {
        split(fileContent);
    }

    public void split(String fileContent) {
        tokenizer = new StringTokenizer(fileContent, SPLITTER_INTO_SENTENCES);

        while (tokenizer.hasMoreTokens()) {
            text.addSentence(tokenizer.nextToken());
        }
    }

    public Text getText() {
        return text;
    }

    private void findPalindrom() {
        for (Sentence element : text.getText()) {
            if (element.isPalindrome(element.sentence)) {
                palindromMap.put(element.sentence.length(), element);
            }
        }
    }

    public void showPalindrom() {
        findPalindrom();

        if (!palindromMap.isEmpty()) {
            System.out.println("The longest palindrom is:");
            System.out.println(max());
        } else {
            System.out.println("Into this text wasn't finded any palindroms");
        }
    }

    private String max() {
        int max = 0;
        Sentence element = null;
        for (Integer el : palindromMap.keySet()) {
            if (el > max) {
                max = el;
            }
        }
        element = palindromMap.get(max);

        return element.sentence;
    }

    // easy test
    public static void main(String[] args) {
        String content = Reader.read(Files.PALINDROM.getFileName());
        Splitter splitter = new Splitter(content);
        splitter.showPalindrom();
    }

}

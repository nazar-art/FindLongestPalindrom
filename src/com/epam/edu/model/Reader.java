package com.epam.edu.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    private static final String RELATIVE_PATH = "./resourses/gutenberg/";

    // read file as one line
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new FileReader(new File(RELATIVE_PATH + fileName).getAbsoluteFile()))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

/*	// easy test
	public static void main(String[] args) {
		String file = Reader.read("palindrom.txt");
		System.out.println(file);
	}*/
}

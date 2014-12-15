package com.epam.edu.view;


public enum Files {

    ALICE_IN_WONDERLAND("alice.txt"), MONTE_CRISTO("cristo.txt"),
    PALINDROM("palindrom.txt");

    String filename;

    private Files(String name) {
        filename = name;
    }

    public String getFileName() {
        return filename;
    }

/*	// easy test
    public static void main(String[] args) {
		for (Files string : Files.values()) {
			System.out.println(string + " : " + string.getFileName());
		}
	}*/
}

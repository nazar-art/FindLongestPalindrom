package com.epam.edu.view;

import static com.epam.edu.view.Files.*;

import java.util.HashMap;
import java.util.Scanner;

import com.epam.edu.controller.Splitter;
import com.epam.edu.model.Reader;

public class Application {

	//private static final Logger LOG = Logger.getLogger(Application.class);

	private HashMap<String, Command> map;
	private String fileText = null;

	private static final String info = "For the start enter number of file which you want to check for longest palindrom:\n"
			+ "1 - \"Alice in Wonderland\" by Lewis Carroll\n"
			+ "2 - file with few knowen english palindromes\n"
			+ "q - for quit";

	public Application() {
		map = new HashMap<>();
		init();
	}

	private void init() {
		map.put("1", new Command() {
			@Override
			public void execute() {
				fileText = Reader.read(ALICE_IN_WONDERLAND.getFileName());
				new Splitter(fileText).showPalindrom();
			}
		});

		map.put("2", new Command() {
			@Override
			public void execute() {
				fileText = Reader.read(PALINDROM.getFileName());
				new Splitter(fileText).showPalindrom();
			}
		});

/*		map.put("3", new Command() {
			@Override
			public void execute() {
				fileText = Reader.read(PALINDROM.getFileName());
				new Splitter(fileText).showPalindrom();
			}
		});*/

		map.put("q", new Command() {
			@Override
			public void execute() {
				System.out.println("Good bye!");
				System.exit(0);
			}
		});
	}

	public void start() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println(info);
		
		while (true) {
			while (scan.hasNext()) {
				String input = scan.next();
				
				check(input);
			} 
		}
	}

	private void check(String input) {
		for (String in : map.keySet()) {
			if (!map.containsKey(input)) {
				failCheck();
				return;
			} else if (in.equals(input)) {
				map.get(in).execute();
			}
		}
	}

	private void failCheck() {
		System.out.println("You need to enter the correct number!");
		System.out.println(info);
	}

}

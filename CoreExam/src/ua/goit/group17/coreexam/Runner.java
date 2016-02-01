package ua.goit.group17.coreexam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Runner {
	private static final String DEFAULT_ANAGRAM_FILE = "anagram.txt";
	private static LinkedList<String> words = new LinkedList<>();
	private static String fileName=DEFAULT_ANAGRAM_FILE;
	
	
	private static LinkedList<String> readFile(String fileName) {
		
		LinkedList<String> resultWords = new LinkedList<>();
		Scanner inputStrings=null;
		String [] words;
		String str;
		try {
			inputStrings = new Scanner (new BufferedReader(new FileReader(fileName)));
			while (inputStrings.hasNext()) {
				str = inputStrings.next().trim();
				words = str.split("[\\p{Punct}\\s]+");
				resultWords.addAll(Arrays.asList(words));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error!!! File " + fileName + " not found!");
			resultWords=null;
		}
		finally {
			if (inputStrings!=null) {
				inputStrings.close();
			}
		}	
		return resultWords;
	}
	
	private static void fileErrorMessage() {
		System.out.println("Error in file " + fileName + ". Try to use another file!");
	}
	
	public static void main(String[] args) {
		boolean exit=false;
		Scanner kbdInput=new Scanner(System.in);
		String userInput;
		while (!exit) {

			System.out.println(">>> Anagram search program <<<");
			System.out.println("1. Select file to search anagrams. Current file:" + fileName);
			System.out.println("2. Search Anagrams in current file: " + fileName);
			System.out.println("3. Search anagrams for entered word in file: " + fileName);
			System.out.println("0. Exit");
			System.out.print("Please choose:");

			userInput = kbdInput.next();
			switch (userInput) {
				case "1": 	System.out.print("Enter File Name: ");
							fileName = kbdInput.next();
							words=readFile(fileName); 
							break;
				case "2": 	words=readFile(fileName); 
							if (null==words) fileErrorMessage();
							else {
								List<String> anagrams = Anagram.getAnagramsFromList(words);
								if (anagrams.size()>0) {
									System.out.println("Anagrams found in the file:" + fileName);
									for (String s : anagrams) {
										System.out.println(s);
									}

								} else System.out.println("Anagrams NOT found in file:" + fileName + ".");
							}
							System.out.println();
							break;
				case "3":	if (null==words) fileErrorMessage();
							else {
								System.out.print("Enter word: ");
								userInput = kbdInput.next();
								System.out.println("Anagram to the word: " + userInput + " - " + Anagram.getAnagramInList(words, userInput));
								System.out.println();
							}
							System.out.println();
							break;
				case "0": System.out.println("Bye!");
						  exit=true; 
						  break;
			}
		}
	}
}

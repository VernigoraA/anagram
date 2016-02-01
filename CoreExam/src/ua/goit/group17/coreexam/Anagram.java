package ua.goit.group17.coreexam;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Anagram {

	public static boolean isAnagram(String str1, String str2){
		if (str1.length()!=str2.length()) return false;
		if (str1.compareToIgnoreCase(str2)==0) return false;
		
		char[] charsStr1 = str1.toUpperCase().toCharArray();
		char[] charsStr2 = str2.toUpperCase().toCharArray();

		Arrays.sort(charsStr1);
		Arrays.sort(charsStr2);

		return Arrays.equals(charsStr1, charsStr2);
	}

	public static LinkedList<String> getAnagramsFromList(Collection<String> words) {
		LinkedList<String> resultList = new LinkedList<>();
		StringBuilder resultString;
		boolean isFindAnagram;

		for (String s1: words) {
			resultString=new StringBuilder(s1);
			isFindAnagram=false;
			
			for (String s2: words) {
					if (isAnagram(s1, s2)) {
						isFindAnagram = true;
						resultString.append(", ").append(s2);
					}
			}
			if (isFindAnagram) resultList.add(resultString.toString());
		}
		return resultList;
	}
	
	public static String getAnagramInList(Collection<String> wordsList, String word) {
		for (String s: wordsList) {
			if (isAnagram(word, s)) return s;
		}
		return "";
	}
}

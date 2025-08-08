package com.wipro.basic;

public class ShortestWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "An anagram is a word or phrase formed by rearranging the letters of a different word or phrase";
		
		String[] words = str.split("\\s+");

        String shortestWord = words[0];
        
        for(int i = 1; i < words.length; i++) {
            if(words[i].length() < shortestWord.length() && words.length>3) {
                shortestWord = words[i];
            }
        }

        System.out.println(shortestWord);
	}
}

package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3P4 {

	public static void main(String[] args) {
		// TODO: write your code here
		Scanner sc = new Scanner(System.in);
		System.out.print("We have: ");
		String string = sc.nextLine().trim();
		
		 if (string.isEmpty()) {
	            System.out.println("\nNo strings were entered.");
	            sc.close();
	            return;
	            }
		 
		String[] strings = string.trim().split("\\s*,\\s*");
		
        if (strings.length == 0) {
            System.out.println("\nNo valid strings were entered.");
            sc.close();
            return;
        }
        
		String longest = findLongestString(strings);
		System.out.println("\nThe longest string was: " + longest);
	}

	public static String findLongestString(String[] a) {
		// TODO: write your code here
        if (a == null || a.length == 0) {
            return "";
        }
	       
		String longestString = "";
        int maxLength = 0;
        for(String s : a) {
        	if (s == null || s.isEmpty()) {
                continue;
            }
        	if(s.length() > maxLength) {
        		maxLength = s.length();
        		longestString = s;
        	}
        }
		return longestString;
	}

}

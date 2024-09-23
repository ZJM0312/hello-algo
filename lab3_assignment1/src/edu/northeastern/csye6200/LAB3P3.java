package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3P3 {
	
	public static void main(String[] args) {
		// TODO: write your code here
		System.out.print("Enter the number of values:");
		Scanner sc = new Scanner(System.in);
		int nums = sc.nextInt();
		
		sc.nextLine();
		
		System.out.print("Enter the number:");
		String string = sc.nextLine();
		
		String[] strings = string.trim().split(" ");
		
		if (strings.length != nums) {
            System.out.println("The number of input values does not match the specified number.");
            sc.close();
            return;
        }
		
		int[] values = new int[strings.length];
		for(int i = 0 ; i < strings.length; i++) {
			try {
				values[i] = Integer.parseInt(strings[i]);
			} catch (NumberFormatException e) {
			    System.out.println("Invalid input: Please enter integers separated by spaces.");
			    sc.close();
			    return;
			}
		}
		if (isConsecutiveFour(values)) {
            System.out.println("The list has consecutive fours");
        } else {
            System.out.println("The list has no consecutive fours");
        }
		
		sc.close();
		
	}

	public static boolean isConsecutiveFour(int[] values) {
		// TODO: write your code here
		if (values == null || values.length < 4) {
            return false;
        }
		
		int i = 1, max = 1, n = values.length;
		while(i < n) {
			if(values[i] == values[i - 1]) {
				max++;
				if(max == 4) {
					return true;
				}
			}else {
				max = 1;
			}
		}
		return false;
	}

}


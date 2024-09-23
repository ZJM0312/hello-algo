package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3P1 {
	public static void main(String[] args) {
		// TODO: write your code here
		System.out.print("Enter a credit card number as a long integer:");
		Scanner sc = new Scanner(System.in);
		String cardNumberStr = sc.nextLine().replaceAll("\\s", "");

        if (!cardNumberStr.matches("\\d+")) {
            System.out.println("Invalid input: Credit card number must contain only digits.");
            sc.close();
            return;
        }

        int length = cardNumberStr.length();
        if (length < 13 || length > 16) {
            System.out.println("Invalid input: Credit card number must have between 13 and 16 digits.");
            sc.close();
            return;
        }

        // Parse the string to long
        long cardNumber = 0;
        try {
            cardNumber = Long.parseLong(cardNumberStr);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Number is too large.");
            sc.close();
            return;
        }

        if (isValid(cardNumber)) {
            System.out.println(cardNumber + " is valid");
        } else {
            System.out.println(cardNumber + " is invalid");
        }
		sc.close();
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		// TODO: write your code here
		int length = getSize(number);
        if (length < 13 || length > 16) {
            return false;
        }

        if (!(prefixMatched(number, 4) || prefixMatched(number, 5) ||
              prefixMatched(number, 6) || prefixMatched(number, 37))) {
            return false;
        }

        int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return (sum % 10 == 0);
	}

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		// TODO: write your code here
		int sum = 0;
	    String numStr = Long.toString(number);
	    for (int i = numStr.length() - 2; i >= 0; i -= 2) {
	        int digit = Character.getNumericValue(numStr.charAt(i));
	        sum += getDigit(digit * 2);
	    }
	    return sum;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of
	 * the two digits
	 */
	public static int getDigit(int number) {
		// TODO: write your code here
		return (number < 10) ? number : ( number / 10 + number % 10 );
	}

	/** Return sum of odd place digits in number */
	public static int sumOfOddPlace(long number) {
		// TODO: write your code here
		int sum = 0;
	    String numStr = Long.toString(number);
	    for (int i = numStr.length() - 1; i >= 0; i -= 2) {
	        int digit = Character.getNumericValue(numStr.charAt(i));
	        sum += digit;
	    }
	    return sum;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		// TODO: write your code here
		long prefix = getPrefix(number, getSize(d));
		return prefix == d;
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		// TODO: write your code here
		int count = 0;
		while(d != 0) {
			d = d / 10;
			count++;
		}
		return count;
	}

	/**
	 * Return the first k number of digits from number. If the number of digits
	 * in number is less than k, return number.
	 */
	public static long getPrefix(long number, int k) {
		// TODO: write your code here
		int size = getSize(number);
		if(size < k) {
			return number;
		}else {
			return (long) (number / Math.pow(10, size - k));
		}
	}
}

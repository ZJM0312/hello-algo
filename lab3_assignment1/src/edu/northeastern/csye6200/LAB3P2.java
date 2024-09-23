package edu.northeastern.csye6200;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LAB3P2 {
	public static void main(String[] args) {
		// TODO: write your code here
		System.out.print("Input array:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		String[] strings = input.trim().split(" ");
		int[] nums = new int[strings.length];
		for(int i = 0; i < strings.length; i++) {
			try {
			    nums[i] = Integer.parseInt(strings[i]);
			} catch (NumberFormatException e) {
			    System.out.println("Invalid input: Please enter integers separated by spaces.");
			    return;
			}
		}
		
		System.out.println();
		
		reverseArray(nums); 
        rotateArray(nums, 2);     
        sortedArray(nums);      
        largestElement(nums); 

        sc.close();
	}

	public static void reverseArray(int[] nums) {
		// TODO: write your code here
		if(nums == null || nums.length == 0) {
			return;
		}
		int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
		System.out.println("Reversed Array: " + Arrays.toString(nums));
	}
	
	public static void rotateArray(int[] nums, int places) {
		// TODO: write your code here
		if(nums == null || nums.length == 0) {
			return;
		}
		int n = nums.length;
		places = places % n;
		if (places < 0) {
	        places += n;
	    }
	    if (places == 0) {
	        System.out.println("Rotated Array: " + Arrays.toString(nums));
	        return;
	    }
		reverse(nums, 0, places  -1);
		reverse(nums, places, n - 1);
		
        System.out.println("Rotated Array: " + Arrays.toString(nums));
	}
	
	private static void reverse(int[] nums, int a, int b) {
		if(nums == null || nums.length == 0) {
			return;
		}
		while(a < b) {
			int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
            a++;
            b--;
		}
	}
	
	public static void sortedArray(int[] nums) {
		// TODO: write your code here
		if(nums == null || nums.length == 0) {
			return;
		}
		for(int i = 0; i < nums.length - 1; i++) {
			int tempMin = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[tempMin]) {
					tempMin = j;
				}
			}
			swap(nums, i, tempMin);
		}
		System.out.println("Sorted Array: " + Arrays.toString(nums));
	}
	
	private static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void largestElement(int[] nums) {
		// TODO: write your code here
		if (nums == null || nums.length == 0) {
            return;
        }
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
		System.out.println("The largest element: " + max);
	}
	
}


package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class E179_LargestNumber {

	public static void main(String[] args) {
		int[] nums = {10, 2, 234, 7, 9};
		System.out.println(largestNumber1(nums));

	}
	
	
	public static String largestNumber1(int[] nums) {
		String[] strings = new String[nums.length];
		for (int i = 0; i < nums.length; i++)
			strings[i] = String.valueOf(nums[i]);
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				// TODO Auto-generated method stub
				String order1 = a + b;
	            String order2 = b + a;
	           return order2.compareTo(order1);
			}
		});
		StringBuffer sB = new StringBuffer();
        for (String string : strings) {
            sB.append(string);
        }

        return sB.toString();
		
	}
}

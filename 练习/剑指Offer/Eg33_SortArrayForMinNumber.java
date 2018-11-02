package com.JianZhiOffer;

import java.util.Arrays;
import java.util.Comparator;

public class Eg33_SortArrayForMinNumber{
	
	public static void main(String[] args) {
		int[] a = {3, 32, 321};
		System.out.println(PrintMinNumber(a));
	}
	public static String PrintMinNumber(int[] numbers) {
		Integer[] a = new Integer[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			a[i] = Integer.valueOf(numbers[i]);
		}
		Arrays.sort(a, new NumberCompare());
		StringBuffer ans = new StringBuffer();
		for (int i = 0; i < a.length; i++) 
			ans.append(a[i]);
		return ans.toString();
	}
}

class NumberCompare implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		String s1 = o1 + "" + o2;
		String s2 = o2 + "" + o1;
		return s1.compareTo(s2);
	}
	
}

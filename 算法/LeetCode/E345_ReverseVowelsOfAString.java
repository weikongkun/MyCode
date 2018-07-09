package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class E345_ReverseVowelsOfAString {
	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
	}
	public static String reverseVowels(String s) {
		HashSet<Character> list = new HashSet
				<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		int lo = 0, hi = s.length() - 1;
		char[] arr = s.toCharArray();
		while (lo < hi) {
			while (!list.contains(arr[lo]) && lo < hi) lo++;
			while (!list.contains(arr[hi]) && lo < hi) hi--;
			if (lo < hi) {
				swap(arr, lo, hi);
				lo++; hi--;
			}
		}
		return new String(arr);
    }
	
	private static void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}
}

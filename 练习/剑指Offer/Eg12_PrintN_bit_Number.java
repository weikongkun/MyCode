package com.JianZhiOffer;

public class Eg12_PrintN_bit_Number {
	public static void main(String[] args) {
	int n = 3;
	if (n <= 0)
		return;
	printAllNumber("", n, 0);		
	}
	
	public static void printAllNumber(String str, int n, int t) {
		if (t == n) {
			printNumber(str);
			return;
		}
		for (int i = 0; i < 10; i++) {
			printAllNumber(str + i, n, t + 1);
		}
		
	}
	
	public static void printNumber(String str) {
		int i = 0;
		while (i < str.length()) {
			if (str.charAt(i) == '0')
				i++;
			else
				break;
		}
		
		if (i == str.length())
			return;
		System.out.println(str.substring(i));
	}
}

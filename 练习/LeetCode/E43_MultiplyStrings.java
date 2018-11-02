package com.leetCode;

public class E43_MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "498828660196";
		String num2 = "840477629533";
		System.out.println(oneMultiplyMore('4', "12"));
		System.out.println(multiply(num1, num2));
	}
	
	public static String multiply(String num1, String num2) {
		long res = 0;
		for (long i = num2.length() - 1; i >= 0; i--) {
			res += oneMultiplyMore(num2.charAt((int)i), num1) * ((long)Math.pow(10, num2.length() - i - 1));
		}
		return res + "";
    }
	public static long oneMultiplyMore(char c, String num) {
		long res = 0;
		long one = c - '0';
		for (long i = num.length() - 1; i >= 0; i--) {
			res += (num.charAt((int)i) - '0') * ((long)Math.pow(10, num.length() - i - 1)) * one;
		}
		return res;
	}

}

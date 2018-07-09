package com.leetCode;

public class E125_ValidPalindrome {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		if (s.length() == 0) return true;
		int lo = 0, hi = s.length() - 1;
		while (true) {
			while (!isValidChar(s.charAt(lo)) && lo < hi) lo++;
			while (!isValidChar(s.charAt(hi)) && lo < hi) hi--;
			if (lo >= hi) break;
			if (s.charAt(lo) != s.charAt(hi)) return false;
			lo++;
			hi--;
		}
		return true;
	}
	private boolean isValidChar(char c) {
		return (c >= 'a' && c <= 'z') ||  (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
	}

}

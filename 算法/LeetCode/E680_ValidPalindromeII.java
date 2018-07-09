package com.leetCode;

import javax.swing.text.DefaultEditorKit.CutAction;

public class E680_ValidPalindromeII {
	public static void main(String[] args) {
	}
	
	public boolean validPalindrome(String s) {
		int lo = 0, hi = s.length() - 1;
		while (lo < hi) {
			if (s.charAt(lo) != s.charAt(hi)) {
				return isPalindrome(s, lo, hi - 1) || isPalindrome(s, lo + 1, hi);
			}
			lo++;hi--;
		}
		return true;
	}
	private boolean isPalindrome(String s, int lo, int hi) {
		while (lo < hi) {
			if (s.charAt(lo++) != s.charAt(hi--))
				return false;
		}
		return true;
	}

}

package com.leetCode;

public class E9_PalindromeNumber {
	public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
        	if (s.charAt(lo) != s.charAt(hi)) return false;
        	lo++;hi--;
        }
        return true;
    }
}

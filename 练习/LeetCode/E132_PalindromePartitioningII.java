package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class E132_PalindromePartitioningII {
	public static void main(String[] args) {
		int res =  new E132_PalindromePartitioningII().minCut("aba");
		System.out.println(res);
	}
	//超时
	public int minCut(String s) {
		if (s == null || s.length() == 0) return 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (partition(s, 0, i))
				return i;
		}
		return s.length() - 1;
    }
	private boolean partition(String s, int cur, int partitions) {
		if (partitions == 0) {
			if (cur < s.length() && isPalindrome(s, cur, s.length() - 1))
				return true;
			else return false;
		}
		if (cur == s.length()) return false;
		
		for (int i = cur; i < s.length(); i++) {
			if (isPalindrome(s, cur, i) && partition(s, i + 1, partitions - 1))
				return true;
		}
		return false;
		
	}
	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
	
//==========================method2 DP =================================
}

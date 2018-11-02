package com.leetCode;

import java.util.*;

public class LOLSSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcbb";
		System.out.println("ans = " + lengthOfLongestSubstring(s));
		
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0, i = 0, j = 0;
		Set<Character> set = new HashSet<>();
		
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			}
			else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

}

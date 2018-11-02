package com.leetCode;

public class E392_IsSubsequence {

	public static void main(String[] args) {
		System.out.println(isSubsequence("axc", "ahbgdc"));
	}
	public static boolean isSubsequence(String s, String t) {
		int sIndex = 0;
		int tIndex = 0;
		while (sIndex < s.length() && tIndex < t.length()) {
			if (t.charAt(tIndex) == s.charAt(sIndex)) sIndex++;
			tIndex++;
		}
		if (sIndex == s.length()) return true;
		return false;
	}

}

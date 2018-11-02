package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class E131_PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if (s == null || s.length() == 0) return res;
		backtracking(s, new ArrayList<>(), 0, res);
		return res;
    }
	private void backtracking(String s, List<String> list, int cur, List<List<String>> res) {
		if (cur == s.length()) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = cur; i < s.length(); i++) {
			if (!isPalindrome(s, cur, i)) continue;
			list.add(s.substring(cur, i + 1));
			backtracking(s, list, i + 1, res);
			list.remove(list.size() - 1);
		}
	}
	private boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}

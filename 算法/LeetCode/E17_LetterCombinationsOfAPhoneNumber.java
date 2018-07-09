package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class E17_LetterCombinationsOfAPhoneNumber {
	
	private static HashMap<Integer, String> numToLetter = new HashMap<>();
	static {
		numToLetter.put(2, "abc");
		numToLetter.put(3, "def");
		numToLetter.put(4, "ghi");
		numToLetter.put(5, "jkl");
		numToLetter.put(6, "mno");
		numToLetter.put(7, "pqrs");
		numToLetter.put(8, "tuv");
		numToLetter.put(9, "wxyz");
	}
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) return res;
		combination(new StringBuilder(), digits, res);
		return res;
		
	}
	public void combination(StringBuilder sb, String digits, List<String> res) {
		if (sb.length() == digits.length()) {
			res.add(sb.toString());
			return;
		}
		String letters = numToLetter.get(digits.charAt(sb.length()) - '0');
		for (char ch : letters.toCharArray()) {
			sb.append(ch);
			combination(sb, digits, res);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}

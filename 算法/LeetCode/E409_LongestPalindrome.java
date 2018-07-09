package com.leetCode;

import java.util.HashMap;

public class E409_LongestPalindrome {
	public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) 
        	map.put(ch, map.getOrDefault(ch, 0) + 1);
        int res = 0; 
        int one = 0;
        for (Character key : map.keySet()) {
        	if (map.get(key) == 1) one++;
        	if (map.get(key) % 2 == 0) res += map.get(key);
        	if (map.get(key) % 2 == 1 && map.get(key) > 1) {
        		res += map.get(key) - 1;
        		one++;
        	}
        }
        if (one > 0) res++;
        return res;
    }
}

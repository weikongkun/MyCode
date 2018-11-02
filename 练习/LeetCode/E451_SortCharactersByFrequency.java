package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class E451_SortCharactersByFrequency {
	public static void main(String[] args) {
		System.out.println(frequencySort("cccaaa"));
	}
	public static String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		List<Character>[] listArray = new List[s.length() + 1];
		for (Character ch : map.keySet()) {
			int fre = map.get(ch);
			if (listArray[fre] == null)
				listArray[fre] = new ArrayList<>();
			listArray[fre].add(ch);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = listArray.length - 1; i >= 0; i--) {
			if (listArray[i] == null)
				continue;
			for (Character ch : listArray[i]) {
				int index = i;
				while (index-- > 0) {
					sb.append(ch);
				}
			}
		}
		return sb.toString();
	}
}

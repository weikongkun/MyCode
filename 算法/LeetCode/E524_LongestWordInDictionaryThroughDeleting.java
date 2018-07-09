package com.leetCode;

import java.util.List;
import java.util.Queue;

public class E524_LongestWordInDictionaryThroughDeleting {
	public static void main(String[] args) {
	}
	
	public String findLongestWord(String s, List<String> d) {
		for (int i = d.size() - 1; i >= 0; i--)
			if (!isContain(s, d.get(i))) 
				d.remove(i);
		if (d.size() == 0) return "";
		int index = 0;
		for (int i = 1; i < d.size(); i++) {
			if (d.get(i).length() < d.get(index).length()) continue;
			else if (d.get(i).length() > d.get(index).length()) index = i;
			else index = d.get(index).compareTo(d.get(i)) < 0 ? index : i;
		}
		return d.get(index);
	}
	public boolean isContain(String s, String sub) {
		int indexS = 0, indexSub = 0;
		 while (indexS < s.length() && indexSub < sub.length()) {
			 if (s.charAt(indexS) == sub.charAt(indexSub)) indexSub++;
			 indexS++;
		 }
		 if (indexSub >= sub.length()) return true;
		 return false;
	}

}

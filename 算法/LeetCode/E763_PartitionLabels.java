package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class E763_PartitionLabels {
	public List<Integer> partitionLabels(String S) {
		if (S.length() == 0) return new ArrayList<>();
        int[] lastIndex =  new int[26];
        for (int i = 0; i < S.length(); i++) 
        	lastIndex[S.charAt(i) - 'a'] = i;
        int first = 0;
        int last = 0;
        List<Integer> list = new ArrayList<>();
        while (first < S.length()) {
        	last = first;
        	for (int i  = first; i <= last && i < S.length(); i++) {
        		int temp = lastIndex[S.charAt(i) - 'a'];
        		if (temp > last) last = temp;
        	}
        	list.add(last - first + 1);
        	first = last + 1;
        }
        return list;
    }
}

package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E127_WordLadder {
	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[] {"hot","dot","dog","lot","log","cog"});
		System.out.println(ladderLength("hit", "cog", list));
	}
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        HashMap<String, ArrayList<String>> map = new HashMap<>(wordList.size() + 1);
        for (int i = 0; i < wordList.size(); i++) {
        	for (int j = i + 1; j < wordList.size(); j++) {
        		if (isDifferOneCh(wordList.get(i), wordList.get(j))) {
        			if (map.get(wordList.get(i)) == null) map.put(wordList.get(i), new ArrayList<String>());
        			map.get(wordList.get(i)).add(wordList.get(j));
        			if (map.get(wordList.get(j)) == null) map.put(wordList.get(j), new ArrayList<String>());
        			map.get(wordList.get(j)).add(wordList.get(i));
        		}
        	}
        }
        for (int i = 0; i < wordList.size(); i++) {
        	if (isDifferOneCh(beginWord, wordList.get(i))) {
        		if (map.get(beginWord) == null) map.put(beginWord, new ArrayList<String>());
        		map.get(beginWord).add(wordList.get(i));
        	}
        }
        System.out.println(map);
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, Boolean> marked = new HashMap<>();
        distance.put(beginWord, 1);
        marked.put(beginWord, true);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
        	String str = queue.poll();
        	List<String> list = map.get(str);
        	if (list == null) continue;
        	for (String s : list) {
				if (marked.get(s) == null) {
					distance.put(s, distance.get(str) + 1);
					marked.put(s, new Boolean(true));
					queue.add(s);
				}
			}
        }
        System.out.println(distance);
        return distance.get(endWord) == null ? 0 : distance.get(endWord);
        
    }
	public static boolean isDifferOneCh(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
		int count = 0;
		for (int i = 0; i < s1.length() && count <= 1; i++) {
			if (s1.charAt(i) != s2.charAt(i)) count++;
		}
		if (count == 1) return true;
		return false;
	}
}

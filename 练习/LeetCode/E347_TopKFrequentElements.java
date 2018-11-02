package com.leetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class E347_TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3};
		System.out.println(topKFrequency(nums, 2));
	}
	public static List<Integer> topKFrequency(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
			else map.put(nums[i], 1);
		}
		Set<Entry<Integer, Integer>> set = map.entrySet();
		List<Entry<Integer, Integer>> list = new ArrayList<>();
		list.addAll(set);
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue() != o2.getValue() ? o1.getValue() - o2.getValue() : o1.getKey() - o2.getKey();  
			}
		});
		List<Integer> res = new ArrayList<>();
		for (int i = nums.length - k; i < nums.length - 1; i++)
			res.add(list.get(i).getKey());
		return res;
			
		
	}

}

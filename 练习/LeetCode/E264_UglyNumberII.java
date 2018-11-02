package com.leetCode;

import java.util.ArrayList;

public class E264_UglyNumberII {

	public static void main(String[] args) {
		nthUglyNumber(10);
	}
	
	public static int nthUglyNumber(int n) {
		if (n <= 0) return 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		int indexOf2 = 0, indexOf3 = 0, indexOf5 = 0;
		
		while (list.size() < n) {
			int nextUgly = minOfThree(list.get(indexOf2) * 2, list.get(indexOf3) * 3, list.get(indexOf5) * 5);
			list.add(nextUgly);
			while (2 * list.get(indexOf2) <= nextUgly) indexOf2++;
			while (3 * list.get(indexOf3) <= nextUgly) indexOf3++;
			while (5 * list.get(indexOf5) <= nextUgly) indexOf5++;
		}
		System.out.println(list);
		return list.get(n - 1);
	}
	
	public static int minOfThree(int i, int j, int k) {
		return Math.min(k, Math.min(i, j));
	}

}

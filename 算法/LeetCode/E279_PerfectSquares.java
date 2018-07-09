package com.leetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class E279_PerfectSquares {
	//图的bfs
	public static void main(String[] args) {
		System.out.println(numSquares(207));
		System.out.println(isSquareNum(Math.abs(1 - 10)));
	}
	public static int numSquares(int n) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i <= n; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < i; j++) {
				if (isSquareNum(i - j)) {
					if (map.get(i) == null) map.put(i, new ArrayList<Integer>());
					map.get(i).add(j);
				}
			}
			System.out.println(map.get(i));
		}
		System.out.println("-----------------------------------");
		for (Integer i : map.keySet()) {
			System.out.println(map.get(i));
		}
		
		boolean[] marked = new boolean[n + 1];
		int[] distance = new int[n + 1];
		Arrays.fill(marked, false);
		Arrays.fill(distance, 0);
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		marked[n] = true;
		while (!queue.isEmpty()) {
			int k = queue.poll();
			if (k == 0) return distance[0];
			ArrayList<Integer> list = map.get(k); 
			for (Integer i : list) {
				if (!marked[i]) {
					marked[i] = true;
					distance[i] = distance[k] + 1;
					queue.offer(i);
				}
			}
		}
		return distance[0];
	}
	public static boolean isSquareNum(int n) {
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if(i * i == n) return true;
		}
		return false;
	}
}

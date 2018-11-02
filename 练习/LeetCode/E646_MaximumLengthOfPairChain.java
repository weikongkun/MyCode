package com.leetCode;

import java.util.Arrays;

public class E646_MaximumLengthOfPairChain {
	public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        Pair[] ps = new Pair[pairs.length];
        for (int i = 0; i < pairs.length; i++) 
        	ps[i] = new Pair(pairs[i][0], pairs[i][1]);
        Arrays.sort(ps);
        int[] dp = new int[ps.length];
        for (int i = 0; i < ps.length; i++) {
        	int max = 0;
        	for (int j = 0; j < i; j++) {
        		if (ps[j].y < ps[i].x)
        			max = Math.max(max, dp[j]);
        	}
        	dp[i] = max + 1;
        }
        return maxOfArr(dp);
    }
	public int maxOfArr(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			max = Math.max(max, i);
		}
		return max;
	}
	class Pair implements Comparable<Pair>{
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}
		public String toString() {
			return "[" + x + ", " + "]";
		}
	}
}

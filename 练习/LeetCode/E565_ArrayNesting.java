package com.leetCode;

public class E565_ArrayNesting {
	public int arrayNesting(int[] nums) {
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	if (visited[i]) continue;
        	visited[i] = true;
        	int cnt = 1;
        	int next = nums[i];
        	while (next != i) {
        		visited[next] = true;
        		next = nums[next];
        		cnt++;
        	}
        	max = Math.max(cnt, max);
        }
        return max;
    }
}

package com.leetCode;

import java.util.Stack;

public class E739_DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
	    int n = temperatures.length;
	    int[] res = new int[n];
	    Stack<Integer> stack = new Stack<>();
	    for (int i = 0; i < n; i++) {
	    	while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
	    		int idx = stack.pop();
	    		res[idx] = i - idx;
	    	}
	    	stack.push(i);
	    }
	    return res;
	}
}

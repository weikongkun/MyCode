package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class E128_LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
	    Map<Integer, Integer> numCnts = new HashMap<>();
	    for (int num : nums) {
	        numCnts.put(num, 1);
	    }
	    for (int num : nums) {
	        count(numCnts, num);
	    }
	    int max = 0;
	    for (int num : nums) {
	        max = Math.max(max, numCnts.get(num));
	    }
	    return max;
	}

	private int count(Map<Integer, Integer> numCnts, int num) {
	    if (!numCnts.containsKey(num)) {
	        return 0;
	    }
	    int cnt = numCnts.get(num);
	    if (cnt > 1) {
	        return cnt;
	    }
	    cnt = count(numCnts, num + 1) + 1;
	    numCnts.put(num, cnt);
	    return cnt;
	}
}

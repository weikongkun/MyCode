package com.leetCode;

import java.util.List;

public class E139_WordBreak {
	//完全背包
	public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
	    boolean[] dp = new boolean[n + 1];
	    dp[0] = true;
	    for (int i = 1; i <= n; i++) {
	        for (String word : wordDict) { // 每个单词可以使用多次
	            int len = word.length();
	            if (len <= i && word.equals(s.substring(i - len, i))) {
	                dp[i] = dp[i] || dp[i - len];
	            }
	        }
	    }
	    return dp[n];
    }
}

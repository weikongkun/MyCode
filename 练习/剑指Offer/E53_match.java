package com.JianZhiOffer;

public class E53_match {
	public boolean match(char[] str, char[] pattern) {
		if (str == null && pattern == null) return false;
		if (str.length == 0 && str.length == 0) return true;
		return matchCore(str, 0, pattern, 0);
    }
	private boolean matchCore(char[] str, int m, char[] pattern, int n) {
		if (m == str.length && n == pattern.length) return true;
		if (m != str.length && n == pattern.length) return false;
		if (n < pattern.length - 1 && pattern[n + 1] == '*') {
			if (pattern[m] == str[n] || pattern[m] == '.') {
				return matchCore(str, m + 1, pattern, n) || matchCore(str, m + 1, pattern, n + 2) ||
						matchCore(str, m, pattern, n + 2);
			}else {
				return matchCore(str, m, pattern, n + 2);
			}
		}
		if (str[m] == pattern[n] || pattern[n] == '.')
			return matchCore(str, m + 1, pattern, n + 1);
		return false;
	}
	
	public boolean match2	(char[] str, char[] pattern) {
		int m = str.length, n = pattern.length;
	    boolean[][] dp = new boolean[m + 1][n + 1];
	    dp[0][0] = true;
	    for (int i = 1; i <= n; i++)
	        if (pattern[i - 1] == '*')
	            dp[0][i] = dp[0][i - 2];

	    for (int i = 1; i <= m; i++)
	        for (int j = 1; j <= n; j++)
	            if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
	                dp[i][j] = dp[i - 1][j - 1];
	            else if (pattern[j - 1] == '*')
	                if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.')
	                    dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
	                else
	                    dp[i][j] = dp[i][j - 2];
	    return dp[m][n];
    }
}

package com.leetCode;
/**
 * 
 * <p>Title:StringToInteger</p>
 * <p>Description: </p>
 * @auther Administrator
 * @data 2018年2月7日 上午11:12:46
 */
public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("-2147483648"));
	}
	
	public static int myAtoi(String str) {
		if (str.length() == 0) return 0;
        char[] chArray = str.toCharArray();
        long ans = 0;
        int lo = 0, hi = str.length() - 1;
        while (chArray[lo] == ' ') lo++;
        while (chArray[hi] == ' ') hi--;
        if (chArray[lo] == '+') {
        	if (hi - lo == 0) return 0;
            int start = lo + 1;
            while (chArray[start] == 0) start++;
            for (; start <= hi; start++) {
                if (chArray[start] > '9' || chArray[start] < '0') {
                	break;
                }
                else ans = ans * 10 + (chArray[start] - '0');
                if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
        }
        else if (chArray[lo] == '-') {
        	if (hi - lo == 0) return 0;
            int start = lo + 1;
            while (chArray[start] == 0) start++;
            for (; start <= hi; start++) {
                if (chArray[start] > '9' || chArray[start] < '0') {
                	break;
                }
                else ans = ans * 10 + (chArray[start] - '0');
                if (0 - ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
//            System.out.println("ans = "  + ans);
            ans = 0 - ans;
        }
        else {
            int start = lo;
            while (chArray[start] == 0) start++;
            for (; start <= hi; start++) {
                if (chArray[start] > '9' || chArray[start] < '0') {
                	break;
                }
                else ans = ans * 10 + (chArray[start] - '0');
                if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            System.out.println(ans);
        }
        if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return (int)ans;
    }

}

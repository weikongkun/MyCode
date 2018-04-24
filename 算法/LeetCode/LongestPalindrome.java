package com.leetCode;

import java.util.Collections;

/**
 * 
 * <p>Title:LongestPalindrome</p>
 * <p>Description: 最长子回文串</p>
 * @auther Administrator
 * @data 2018年2月6日 上午9:56:15
 */
public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("ccc"));
	}
//	public static String longestPalindrome(String s) {
//        boolean[][] b = new boolean[s.length()][s.length()];
//        int start = 0;
//        int maxLength = 0;
//        //初始化，遍历确定最大长度为2的回文字串
//        for (int i = 0; i < s.length(); i++) 
//            for (int j = i; j < s.length(); j++)
//                if (i == j) {
//                    start = i;
//                    maxLength = 1;
//                    b[i][j] = true;
//                }
//                else if (j == i + 1 && s.charAt(i) == s.charAt(j)) {
//                    b[i][j] = true;
//                    start = i;
//                    maxLength = 2;
//                }
//                else b[i][j] = false;
//        
//        for (int i = 3; i < s.length(); i++)
//            for (int j = 0; j < s.length() - i; j++) {
//                if (b[j + 1][j + i - 2] && s.charAt(j) == s.charAt(j + i - 1)) {
//                    b[j][j + i - 1] = true;
//                    start = j;
//                    maxLength = i;
//                }
//                else 
//                    b[j][j + i - 1] = false;
//            }
//        
//        return s.substring(start, start + maxLength);
//    }
	
	public static String longestPalindrome(String s) {
        boolean[][] b = new boolean[s.length()][s.length()];
        int start = 0;
        int maxLength = 0;
        //初始化，遍历确定最大长度为2的回文字串
        for (int i = s.length() - 1; i >= 0; i--) 
            for (int j = i; j >= 0; j--)
                if (i == j) {
                    start = i;
                    maxLength = 1;
                    b[i][j] = true;
                }
                else b[j][i] = false;
        for (int i = s.length() - 1; i >= 1; i--)
        	if (s.charAt(i) == s.charAt(i - 1)) {
        		b[i - 1][i] = true;
        		start = i - 1;
        		maxLength = 2;
        	}
        
        for (int i = 3; i <= s.length(); i++)
            for (int j = s.length() - 1; j >= i - 1; j--) {
                if (b[j - i + 2][j - 1] && s.charAt(j - i + 1) == s.charAt(j)) {
                    b[j - i + 1][j] = true;
                    start = j - i + 1;
                    maxLength = i;
                }
                else 
                    b[j - i + 1][j] = false;
            }
        
        return s.substring(start, start + maxLength);
    }


}

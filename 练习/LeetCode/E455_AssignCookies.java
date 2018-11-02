package com.leetCode;

import java.util.Arrays;

public class E455_AssignCookies {

	public static void main(String[] args) {
		int[] g = {1, 2, 3};
		int[] s = {1, 1};
		System.out.println(findContentChildren(g, s));
	}
	
	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		
		int i = 0, j = 0;
		while (i < g.length) {
			while (j < s.length && s[j] < g[i]) {
				j++;
			}
			if (j >= s.length) break;
			i++;j++;
			
		}
		return i;
	}

}

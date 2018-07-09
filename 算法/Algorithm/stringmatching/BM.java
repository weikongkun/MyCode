package com.stringmatching;

import java.util.Arrays;

public class BM {
	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "issi";
		System.out.println(strStr(haystack, needle));
	}
	public static int strStr(String haystack, String needle) {
        
        int[] index = new int[256];
        Arrays.fill(index, Integer.MAX_VALUE);
        for (int i = 0; i < needle.length(); i++) {
            index[needle.charAt(i)] = i;
        }
        for (int i = 0; i < index.length; i++) {
        	if (index[i] < needle.length()) System.out.print((char)i + ":" + index[i] + " ");
        }
        System.out.println();
        int end = needle.length() - 1;
        while (end < haystack.length()) {
            int start = end - needle.length() + 1;
            int k = end;
            while (k >= start) {
                if (haystack.charAt(k) != needle.charAt(k - start)) {
                    if (index[haystack.charAt(k)] < (k - start)) {
                        end = k - start - index[haystack.charAt(k)] + end;
                        break;
                    }
                    else if (index[haystack.charAt(k)] < needle.length()) {
                    	end++;
                    	break;
                    }
                    else {
                        end = k + needle.length();
                        break;
                    } 
                }
                k--;
            }
            if (k < start) return start;
        }
        return -1;
    }
}

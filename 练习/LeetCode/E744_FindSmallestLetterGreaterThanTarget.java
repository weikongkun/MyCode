package com.leetCode;

public class E744_FindSmallestLetterGreaterThanTarget {
	public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l <= h) {
        	int mid = l + (h - l) / 2;
        	if (letters[mid] <= target) l = mid + 1;
        	else h = mid - 1;
        }
        if (l >= letters.length) return letters[0];
        return letters[l];
    }
}

package com.leetCode;

public class E88_MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] temp = new int[m + n];
		int x1 = 0, x2 = 0;
		for (int i = 0; i < m + n; i++) {
			if (x1 >= m) temp[i] = nums2[x2++];
			else if (x2 >= n) temp[i] = nums1[x1++];
			else if (nums1[x1] <= nums2[x2]) temp[i] = nums1[x1++];
			else temp[i] = nums2[x2++];
		}
		for (int i = 0; i < m + n; i++)
			nums1[i] = temp[i];
	}
}

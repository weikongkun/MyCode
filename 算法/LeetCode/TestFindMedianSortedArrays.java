package com.leetCode;

public class TestFindMedianSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};
		double mid = findMedianSortedArrays(nums1, nums2);
		System.out.println("Mid = " + mid);
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		//保证A的长度小于B的长度
		int[] A = null;
		int[] B = null;
		if(nums1.length <= nums2.length) {
			A = nums1;
			B = nums2;
		}
		else {
			A = nums2;
			B = nums1;
		}
		int m = A.length;
		int n = B.length;
		
		if (m == 0) {
			if (n % 2 == 1)
				return B[n / 2];
			else
				return (B[n / 2] + B[n / 2 - 1]) / 2.0;
		}
		
		int maxOfLeft = A[0], minOfRight = A[0];
		
		int imin = 0, imax = m, half_len = (m + n + 1) / 2; 
		//当m <= n时
		while (imin <= imax) {
			int i = (imin + imax) / 2;
			int j = half_len - i;
			if (i < m && B[j - 1] > A[i]) {
				imin = i + 1;
			}
			else if (i > 0 && A[i - 1] > B[j]) {
				imax = i - 1;
			}
			else {
				
				if (i == 0)
					maxOfLeft = B[j - 1];
				else if (j == 0) 
					maxOfLeft = A[i - 1];
				//else if (j == 0);
				else
					maxOfLeft = Math.max(A[i - 1], B[j - 1]);
				
				if ((m + n) % 2 == 1) 
					return (double)maxOfLeft;
				
				if (i == m) 
					minOfRight = B[j];
				else if (j == n)
					minOfRight = A[i];
				else
					minOfRight = Math.min(A[i], B[j]);
				
				return (maxOfLeft + minOfRight) / 2.0;
					
			}
		}
		
		return -1;
		
	}
	

}

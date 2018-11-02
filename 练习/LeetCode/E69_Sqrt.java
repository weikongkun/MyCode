package com.leetCode;

public class E69_Sqrt {

	public static void main(String[] args) {
	}
	
	public static int mySqrt(int x) {
		if (x <= 1) return x;
		int l = 1, h = x;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			int sqrt = x / mid;
			if (sqrt == mid) return mid;
			else if (sqrt > mid) l = mid + 1;
			else h = mid - 1;
		}
		//返回h
		return h;
	}

}

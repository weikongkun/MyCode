package com.leetCode;

public class E278_FirstBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int firstBadVersion(int n) {
		int l = 1, h = n;
		while (l < h) {
			int mid = l + (h - l) / 2;
			if (isBadVersion(mid)) h = mid;
			else l = mid + 1;
		}
		return l;
	}
	
	public boolean isBadVersion(int version) {
		return true;
	}

}

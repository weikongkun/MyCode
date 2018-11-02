package com.leetCode;

public class E34_SearchForARange {
	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int[] res = searchRange(nums, 8);
		for (int i : res) {
			System.out.println(i + " ");
		}
	}
	public static int[] searchRange(int[] nums, int target) {
		
        int l = 0, h = nums.length - 1;
        int[] res = new int[] {-1, -1};
        if (nums.length == 0) return res;
        while (l < h) {
        	int mid = l + (h - l) / 2;
        	if (target <= nums[mid]) h = mid;
        	else l = mid + 1;
        }
        if (nums[l] == target) res[0] = l;
        
        l = 0;
        h= nums.length - 1;
        while (l < h) {
        	int mid = l + (h - l) / 2 + 1;
        	if (target >= nums[mid]) l = mid;
        	else h = mid - 1;
        }
        if (nums[h] == target) res[1] = h;
        return res;
    }
}

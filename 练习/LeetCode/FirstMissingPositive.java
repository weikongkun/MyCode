package com.leetCode;

public class FirstMissingPositive {
	public static void main(String[] args) {
		int[] arr = new int[] {3, 4, -1, 1};
		
		System.out.println(firstMissingPositive(arr));
	}

	public static int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length && nums[i] > 0 && nums[i] == i + 1) continue;
            else if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != i + 1) {
            	if (nums[nums[i] - 1]  == i + 1) {
            		swap(nums, nums[i] - 1, i);
            		continue;
            	}
            	else if (nums[nums[i] - 1] < i + 1) {
            		swap(nums, nums[i] - 1, nums[nums[i] - 1] - 1);
            		swap(nums, i, nums[i] - 1);
            	}
            	
            }
            
        }
        for (int i = 0; i < nums.length; i++)
        	System.out.print(nums[i] + " ");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            else return i + 1;
        }
//        System.out.println(nums);
        return nums.length + 1;        
    }
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

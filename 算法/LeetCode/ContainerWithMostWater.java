package com.leetCode;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = {1, 1};
		// TODO Auto-generated method stub
		int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0) continue;
            else if (height[i] < 0) {
                for (int j = i + 1; j < height.length; j++) {
                    if (height[j] < 0) {
                        int h = Math.min(Math.abs(height[i]), Math.abs(height[j]));
                        res = res > (h * (j - i)) ? res : (h * (j - i));
                    }
                        
                }
            }
        }
        System.out.println(res);
	}

}

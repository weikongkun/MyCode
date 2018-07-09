package com.leetCode;

public class E605_CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int len = flowerbed.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			int pre = i == 0 ? 0 : flowerbed[i - 1];
			int next = i == len - 1 ? 0 : flowerbed[i + 1];
			if (flowerbed[i] == 0 && pre == 0 && next == 0) {
				count++;
				flowerbed[i] = 1;
			}
		}
		return count >= n;
    }
}

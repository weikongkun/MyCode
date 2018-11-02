package com.JianZhiOffer;

public class Eg4_1_A2ToA1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a1 = {1, 2, 5, 6};
		int[] a2 = {3, 4, 7};
		int[] a3 = a2Toa1(a1, a2);
		for (int i = 0; i < a3.length; i++)
			System.out.print(a3[i] + " ");
	}
	
	public static int[] a2Toa1(int[] a1, int[] a2) {
		int p = a1.length - 1;
		int q = a2.length - 1;
		int[] a3 = new int[p + q + 2];
		int t = p + q + 1;
		while (t >= 0 && p >= 0 && q >= 0) {
			if (a2[q] >= a1[p]) {
				a3[t] = a2[q];
				t--;
				q--;		
			}
			else {
				a3[t] = a1[p];
				t--;
				p--;
			}
		}
		
		return a3;
	}

}

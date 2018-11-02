package com.JianZhiOffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Eg41_2_ContinuesSequenceWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(9));
	}
	
	public static ArrayList<ArrayList<Integer>> solution(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int small = 1, big = 2;
		int sumFromSmallToBig = small + big;
		while (small < (sum + 1) / 2) {
			if (sumFromSmallToBig < sum) {
				big++;
				sumFromSmallToBig += big;
			}
			else if (sumFromSmallToBig > sum) {
				sumFromSmallToBig -= small;
				small++;
			}
			else {
				saveToList(res, small, big);
				big++;
				sumFromSmallToBig += big;
			}
		}
		return res;
	}
	
	public static void saveToList(ArrayList<ArrayList<Integer>> res, int small, int big) {
		ArrayList<Integer> subList = new ArrayList<>();
		for (int i = small; i <= big; i++) subList.add(i);
		res.add(subList);
	}

}

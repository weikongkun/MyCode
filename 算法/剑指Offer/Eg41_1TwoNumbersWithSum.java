package com.JianZhiOffer;

import java.util.ArrayList;

public class Eg41_1TwoNumbersWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[]{1, 2, 4, 7, 11, 16}; 
		System.out.println(FindNumbersWithSum(arr, 10));
	}
	
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int lo = 0, hi = array.length - 1;
        while (lo < hi) {
            if (array[lo] + array[hi] < sum) lo++;
            else if (array[lo] + array[hi] > sum) hi--;
            else 
                break;
        }
        ArrayList<Integer> res = new ArrayList<>();
//        if (lo < hi) {
//        
//        res.add(array[lo]);
//        res.add(array[hi]);
//        return res;
//        }
//        return res;
	        if (lo == hi) return res;
	        else {
	        	res.add(array[lo]);
	        	res.add(array[hi]);
	        	return res;
	        }
	       
    }

}

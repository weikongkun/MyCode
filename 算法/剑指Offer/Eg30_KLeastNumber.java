package com.JianZhiOffer;

import java.util.ArrayList;

public class Eg30_KLeastNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
		ArrayList<Integer> res = GetLeastNumbers_Solution(arr, 10);
		System.out.println(res);
	}
	 public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		 	ArrayList<Integer> ans = new ArrayList<Integer>();
	        if (input == null || input.length < k || input.length == 0 || k == 0) return ans;
	        int start = 0, end = input.length - 1;
	        int index = -1;
	        while (index != k - 1) {
	        	index = Partition(input, start, end);
	            if (index < k - 1) {
	                start = index + 1;
	                index = Partition(input, start, end);
	            } 
	            else {
	                end = index - 1;
	                index = Partition(input, start, end);
	            }
	        }
	        
	        for (int i = 0; i < k; i++)
	            ans.add(input[i]);
	        return ans;
	    }
	    
	    public static int Partition(int[] arr, int lo, int hi) {
	    	if (lo == hi) return lo;
	        int val = arr[lo];
	        int i = lo, j = hi + 1;
	        while (true) {
	            while (arr[++i] < val)
	                if (i == hi)
	                    break;
	            while (arr[--j] > val) 
	                if (j == lo)
	                    break;
	            if (i >= j) break;
	            
	            exch(arr, i, j);
	        }
	        exch(arr, lo, j);
	        return j;
	    }
	    
	    public static void exch(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

}

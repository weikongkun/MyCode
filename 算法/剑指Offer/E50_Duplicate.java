package com.JianZhiOffer;

public class E50_Duplicate {
	public static void main(String[] args) {
		
	}
	
	public boolean duplicate(int numbers[],int length,int [] duplication) {
	    for (int i = 0; i < length; i++) {
	    	if (numbers[i] == i) continue;
	    	while (numbers[i] != i) {
	    		if (numbers[numbers[i]] == numbers[i]) {
	    			duplication[0] = numbers[i];
	    			return true;
	    		} else {
	    			swap(numbers, i, numbers[i]);
	    		}
	    	}
	    }
	    return false;
    }
	
	public void swap(int[] numbers, int i, int j) {
		int temp = numbers[i] ^ numbers[j];
		numbers[i] = temp ^ numbers[i];
		numbers[j] = temp ^ numbers[i];
	}
}

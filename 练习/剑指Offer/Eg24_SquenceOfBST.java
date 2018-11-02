package com.JianZhiOffer;

public class Eg24_SquenceOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 8, 6, 12, 16, 14, 10};
		int[] arr1 = {5, 4, 3, 2, 1};
		System.out.println(VerifySquenceOfBST1(arr1));
	}
	
	public static boolean VerifySquenceOfBST1(int [] sequence) {
		return VerifySquenceOfBST2(sequence, 0, sequence.length - 1);
	}
	public static boolean VerifySquenceOfBST2(int [] s, int lo, int hi) {
		boolean result = true;
		
		if (lo > hi)
			return true;
		else if (lo == hi)
			return true;
		else {
			int root = s[hi];
			int index = lo;
			while (s[index] < root)
				index++;
			for (int i = index; i <= hi - 1; i++)
				if (s[i] < root)
					result = false;
			if (result == true)
				result = VerifySquenceOfBST2(s, lo, index - 1) && VerifySquenceOfBST2(s, index, hi - 1);
			return result;
		}
		
		
		
	}
}

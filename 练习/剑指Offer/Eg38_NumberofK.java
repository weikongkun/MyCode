package com.JianZhiOffer;

public class Eg38_NumberofK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 3, 3};
		System.out.println(GetNumberOfK(arr, 3));
	}
	public static int GetNumberOfK(int [] array , int k) {
        if (array.length == 0 || array == null) return 0;
        int res = 0;
       	int lo = 0, hi = array.length - 1;
       	int mid = 0;
        while (lo <= hi) {
        	mid = lo + (hi - lo) / 2;
            if (k < array[mid]) hi = mid - 1;
            else if (array[mid] < k) lo = mid + 1;
            else {
                for (int i = mid; i >= 0; i--)
                    if (array[i] == k)
                        res++;
                 	else
                        break;
                for (int i = mid; i < array.length; i++)
                    if (array[i] == k)
                        res++;
                	else
                        break;
                res--;
                return res;
            }
        }
        return 0;
    }

}

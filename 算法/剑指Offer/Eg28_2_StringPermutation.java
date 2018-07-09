package com.JianZhiOffer;
import java.util.ArrayList;


public class Eg28_2_StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aa";
		ArrayList<String> ans = Permutation(str);
		System.out.println(ans.toString());
	}
	
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		if (str != null && str.length() > 0) {
			PermutationHelper(str.toCharArray(), 0, res);
			
//			Collections.sort(res);
		}
		return res;
	}
	
	public static void PermutationHelper(char[] cs, int index, ArrayList<String> list) {
		if (index == cs.length - 1) {
			String val = String.valueOf(cs);
			if (!list.contains(val))
				list.add(val);
		}else {
			for (int i = index;  i < cs.length; i++) {
				sweap(cs, index, i);
				PermutationHelper(cs, index + 1, list);
				sweap(cs, index, i);
			}
		}
	}
	
	public static void sweap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}

}

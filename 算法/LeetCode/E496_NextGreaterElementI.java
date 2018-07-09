package com.leetCode;

import java.util.HashMap;
import java.util.Stack;

public class E496_NextGreaterElementI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() &&  s.peek() < nums2[i])
                map.put(s.pop(), nums2[i]);
            s.add(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) res[i] = map.get(nums1[i]);
            else res[i] = -1;
        }
        return res;
    }

}

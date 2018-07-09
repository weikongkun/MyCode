package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class E501_FindModeInBinarySearchTree {
	public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : list) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int key : map.keySet())
            max = Math.max(max, map.get(key));
        int numOfMax = 0;
        for (int key : map.keySet())
            if (map.get(key) == max)
                numOfMax++;
        int[] res = new int[numOfMax];
        int index = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                res[index] = key;
                index++;
            }
        }
        return res;
    }
    public void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
    }
}

package com.JianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class E61_Print {
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (pRoot == null) return res;
		int depth = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(pRoot);
		while (!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> list = new ArrayList<>();
			//奇数�?
			if (depth % 2 == 1) {
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					list.add(node.val);
					if (node.left != null) queue.add(node.left);
					if (node.right != null) queue.add(node.right);
				}
			}else {
				//偶数�?
				Stack<Integer> stack = new Stack<>();
				for (int i = 0; i < size; i++) {
					TreeNode node = queue.poll();
					stack.push(node.val);
					if (node.left != null) queue.add(node.left);
					if (node.right != null) queue.add(node.right);
				}
				while (!stack.isEmpty()) list.add(stack.pop());
			}
			res.add(list);
			depth++;
		}
		return res;
    }
}

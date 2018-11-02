package com.leetCode;

public class E222_CountCompleteTreeNodes {
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		System.out.println(countNodes(node1));
		
	}
	public static int countNodes(TreeNode root) {
		int nodes = 0, h = Height(root);
		while (root != null) {
			if (Height(root.right) == h - 1) {
				nodes += 1 << h;
				root = root.right;
			}
			else {
				nodes += 1 << h - 1;
				root = root.left;
			}
			h--;
		}
		return nodes;
		
	}
	
	public static int Height(TreeNode root) {
		if (root == null) return -1;
		return 1 + Height(root.left);
	}
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {
			val = x;
		}
	}
}

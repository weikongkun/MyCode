package com.leetCode;

import java.util.Map;

public class E110_BalancedBinaryTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		System.out.println(new E110_BalancedBinaryTree().isBalanced(root));
	}
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		System.out.println(height(root.left) + " " + height(root.right));
		int res = height(root.left) - height(root.right);
		System.out.println(res);
		return res <= 1;
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}

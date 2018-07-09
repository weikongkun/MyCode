package com.leetCode;

public class E129_SumRootToLeafNumbers {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		System.out.println(sumNumbers(root));
	}
	
	public static int sumNumbers(TreeNode root) {
		return sum(root, 0);
    }
	public static int sum(TreeNode root, int num) {
		if (root == null) return 0;
		if (root.right == null && root.left == null) return num * 10 + root.val;
		return sum(root.left, num * 10 + root.val) + sum(root.right, num * 10 + root.val);
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}

}

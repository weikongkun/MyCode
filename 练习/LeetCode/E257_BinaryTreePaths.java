package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class E257_BinaryTreePaths {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(23);
		root.right = new TreeNode(245);
		System.out.println(binaryTreePaths(root));
		
	}
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<>();
		if (root == null) return res;
		dfs(root, new StringBuilder(), res);
		return res;
	}
	private static void dfs(TreeNode root, StringBuilder sb, List<String> res) {
		if (root.left == null && root.right == null) {
			res.add(sb.append(root.val).toString());
			sb.delete(sb.length() - (root.val + "").length(), sb.length());
			System.out.println("1:" + sb.toString());
			return;
		}
		if (root.right != null) {
			dfs(root.right, sb.append(root.val + "->"), res);
			sb.delete(sb.length() - 2 - (root.val + "").length(), sb.length());
			System.out.println("2:" + sb.toString());
		}
		if (root.left != null) {
			dfs(root.left, sb.append(root.val + "->"), res);
			sb.delete(sb.length() - 2 - (root.val + "").length(), sb.length());
			System.out.println("3:" + sb.toString());
		}
		
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			this.val = x;
		}
	}

}

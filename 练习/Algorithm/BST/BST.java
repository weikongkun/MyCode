package com.BST;

import java.util.LinkedList;
import java.util.Queue;

import javax.xml.soap.Node;

public class BST {
	//插入操作
	public static TreeNode put(int val, TreeNode root) {
		if (root == null) return new TreeNode(val);
		if (val > root.val) root.right = put(val, root.right);
		else root.left = put(val, root.left);
		return root;
	}
	//查找操作
	public static TreeNode get(int val, TreeNode root) {
		if (root == null) return null;
		if (root.val == val) return root;
		else if (val < root.val) return get(val, root.left);
		else return get(val, root.right);
	}
	//查找第k小的节点
	public static TreeNode select(int k, TreeNode root) {
		int t = size(root.left);
		if (k < t) return select(k, root.left);
		else if (k > t) return select(k - t - 1, root.right);
		else return root;
	}
	//返回指定节点的排名
	public static int rank(TreeNode root, TreeNode node) {
		if (node == null) return 0;
		if (node.val < root.val) return rank(root.left, node);
		else if (node.val > root.val) return size(root.left) + rank(root.right, node) + 1;
		else return size(root.left);
	}
	//删除任意节点
	public static TreeNode delete(TreeNode x, int val) {
		if (x == null) return null;
		if (val < x.val) x.left = delete(x.left, val);
		else if (val > x.val) x.right = delete(x.right, val);
		else {
			if (x.left == null) return x.right;
			if (x.right == null) return x.left;
			TreeNode t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		return x;
	}
	//范围查询
	public static Queue<Integer> keys(TreeNode root, int lo, int hi) {
		Queue<Integer> queue = new LinkedList<>();
		keys(root, queue, lo, hi);
		return queue;
	}
	private static void keys(TreeNode x, Queue<Integer> q, int lo, int hi) {
		int compLo = lo - x.val;
		int compHi = hi - x.val;
		if (compLo < 0) keys(x.left, q, lo, hi);
		if (compLo <= 0 && compHi >= 0) q.offer(x.val);
		if (compHi > 0) keys(x.right, q, lo, hi);
	}
	//删除树的最小节点，返回删除最小节点后的根节点
	public static TreeNode deleteMin(TreeNode root) {
		if (root.left == null) return root.right;
		root.left = deleteMin(root.left);
		return root;
	}
	//获取树的最小节点
	public static TreeNode min(TreeNode root) {
		if (root.left == null) return root;
		return min(root.left);
	}
	//获取某个子树的大小
	private static int size(TreeNode root) {
		if (root == null) return 0;
		return size(root.left) + size(root.right) + 1;
	}
	//内部节点类
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val) {
			this.val = val;
		}
	}
}

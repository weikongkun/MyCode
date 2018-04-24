package com.leetCode;

/**
 * <p>Title:树的遍历</p>
 * <p>Description: </p>
 * @auther Administrator
 * @data 2017年10月30日 下午9:03:21
 */

import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;
public class TreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	/*****************************************************************************/
	/**----------------------------------广度优先搜索----------------------------**/
	/****************************************************************************/
	
	public static void travLevel(TreeNode root, ArrayList<Integer> list) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		if (root == null) return;
		TreeNode node = root;
		queue.offer(node);
		while (!queue.isEmpty()) {
			node = queue.poll();
			list.add(node.val);
			queue.offer(node.left);
			queue.offer(node.right);
		}
	}
	
	/*****************************************************************************/
	/**----------------------------------深度优先搜索----------------------------**/
	/****************************************************************************/
	
	
	/**************后序(笔记)**************/
	public static void postorderTraversal_Iterator(TreeNode root, ArrayList<Integer> list) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode node = root;
		if (node != null) s.push(node);
		while (!s.isEmpty()) {
			if (s.peek().left != node && s.peek().right != node) {
				node = s.peek();
			    //入栈
				while (node != null){
					if (node.left != null) {
						if (node.right != null)
							s.push(node.right);
						s.push(node.left);
					}
					else
						s.push(node.right);
					
					node = s.peek();
				}
				s.pop();
			}	
			node = s.pop();
			list.add(node.val);
		}
    }
	//递归
	public static void postorderTraversal_Rescurive(TreeNode root, ArrayList<Integer> list) {
		if (root == null) return;
		postorderTraversal_Rescurive(root.left, list);
		postorderTraversal_Rescurive(root.right, list);
		list.add(root.val);
	}
	/************中序(笔记)***************/
	//迭代
	public static void midorderTraversal_Iterator(TreeNode root, ArrayList<Integer> list) {
		TreeNode node = root;
		Stack<TreeNode> s = new Stack<>();
		
		while (true) {
			while (node != null) {
				s.push(node);
				node = node.left;
			}
			if (s.isEmpty()) break;
			node = s.pop();
			list.add(node.val);
			node = node.right;
		}
	}
	//递归
	public static void midorderTraversal_Rescurive(TreeNode root, ArrayList<Integer> list) {
		if (root == null) return;
		midorderTraversal_Rescurive(root.left, list);
		list.add(root.val);
		midorderTraversal_Rescurive(root.right, list);
	}
	/***********先序(笔记)***************/
	//法一（递归）
	public static void preorderTraversal_Iterator_1(TreeNode root, ArrayList<Integer> list) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode node = root;
		while (true) {
			while (node != null) {
				list.add(node.val);
				if (node.right != null) 
					s.push(node.right);
				node = node.left;
			}
			
			if (s.isEmpty())
				break;
			node = s.pop();
		}
	}
	
	//法二（递归）
	public static void preorderTraversal_Iterator_2(TreeNode root, ArrayList<Integer> list) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode node = root;
		
		if (node != null) 
			s.push(node);
		else
			return;
		
		while (!s.isEmpty()) {
			node = s.pop();
			list.add(node.val);
			if (node.right != null)
				s.push(node.right);
			if (node.left != null)
				s.push(node.right);
		}
	}
	
	//迭代
	public static void preorderTraversal_Rescurive(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		TreeNode node = root;
		list.add(root.val);
		preorderTraversal_Rescurive(node.left, list);
		preorderTraversal_Rescurive(node.right, list);
	}
	
	
	/**************树节点类************/
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	

}


package com.leetCode;


/**
 * <p>Title:minimum_depth_of_binary_tree</p>
 * <p>Description:Given a binary tree, find its minimum depth.The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node. </p>
 * @auther Administrator
 * @data 2017年10月14日 上午10:44:01
 */
//法一：深度优先搜索
//public class minimum_depth_of_binary_tree {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//	}
//	//错例
//	public int run(TreeNode root) {
//		if (root == null)
//			return 0;
//		
//		else
//			return Math.min(run(root.leftNode) + 1, run(root.leftNode) + 1);
//	}
//
//}
//class TreeNode {
//	int e;
//	TreeNode leftNode;
//	TreeNode rightNode;
//	public TreeNode(int e) {
//		this.e = e;
//	}
//}

//法二
import java.util.LinkedList;
public class Minimum_depth_of_binary_tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public int run(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode node;
		
		int ans = 0;
		while(true) {
			node = queue.poll();
			if (node.leftNode == null && node.rightNode == null)
				break;
			if (node.leftNode != null)
				queue.add(node.leftNode);
			if (node.rightNode != null)
				queue.add(node.rightNode);
		}
		
		return ans;
		
	}

}

class TreeNode {
	int e;
	
	TreeNode leftNode;
	TreeNode rightNode;
	public TreeNode(int e) {
		this.e = e;
	}
}

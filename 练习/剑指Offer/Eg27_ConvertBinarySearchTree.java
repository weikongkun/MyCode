package com.JianZhiOffer;

public class Eg27_ConvertBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode convert(TreeNode root) {
		TreeNode lastNode = null;
		convertNode(root, lastNode);
		
		TreeNode headOfList = lastNode;
		while (headOfList != null && headOfList.left != null)
			headOfList = headOfList.left;
		return headOfList;
	}
	public static void convertNode(TreeNode root, TreeNode lastNode) {
		if (root == null) return;
		TreeNode currentNode = root;
		if (currentNode.left != null)
			convertNode(currentNode.left, lastNode);
		currentNode.left = lastNode;
		
		if (lastNode != null)
			lastNode.right = currentNode;
		
		lastNode = currentNode;
		if (currentNode.right != null)
			convertNode(currentNode.right, lastNode);
		
		
		
	}
	
	

}

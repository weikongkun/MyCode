package com.leetCode;

import com.leetCode.E108_ConvertSortedArrayToBinarySearchTree.TreeNode;

public class E98_ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {

		return isBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isBSTHelper(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		return root.val < max && root.val > min && isBSTHelper(root.left, min, root.val)
				&& isBSTHelper(root.right, root.val, max);
	}
}

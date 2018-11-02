package com.JianZhiOffer;

public class E59_isSymmetrical {
	boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return symetrical(pRoot.left, pRoot.right);
    }
	private boolean symetrical(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		if (left.val != right.val) return false;
		return symetrical(left.right, right.left) && symetrical(left.left, right.right);
	}
}

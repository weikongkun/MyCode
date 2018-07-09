package com.JianZhiOffer;

public class E63_KthNode {
	private int k;
	private int cnt = 0;
	TreeNode kNode;
	TreeNode KthNode(TreeNode pRoot, int k) {
        this.k = k;
        dfs(pRoot);
        return kNode;
    }
	private void dfs(TreeNode root) {
		if (root == null || kNode != null) return;
		dfs(root.left);
		cnt++;
		if (cnt == k) {
			kNode = root;
			return;
		}
		dfs(root.right);
	}
}

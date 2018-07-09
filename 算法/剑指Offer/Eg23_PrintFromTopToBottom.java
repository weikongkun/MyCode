package com.JianZhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Eg23_PrintFromTopToBottom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        if (root == null)
            return list;
        q.add(root);
        TreeNode node = null;
        while (!q.isEmpty()) {
        	node = q.poll();
        	list.add(node.val);
        	if (node.left != null)
        		q.add(node.left);
        	if (node.right != null )
        		q.add(node.right);
        }
        return list;
    }

}

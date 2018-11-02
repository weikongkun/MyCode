package com.leetCode;

import java.util.List;

import com.leetCode.E222_CountCompleteTreeNodes.TreeNode;

public class E109_ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static TreeNode sortedListToBST(ListNode head) {
	
		return sortedList(head);
    }
	public static TreeNode sortedList(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return new TreeNode(head.val);
		ListNode slow = head, fast = head, beforeSlow = null;
		while (fast.next != null && fast.next.next != null) {
			beforeSlow = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//将前半段的尾部设置为null
		TreeNode root = new TreeNode(slow.val);
		if (beforeSlow != null) {
			beforeSlow.next = null;
		}
		//当beforeSlow = null时，slow=fast=head;
		else {
			head = null;
		}
		root.left = sortedList(head);
		root.right = sortedList(slow.next);
		return root;
	}
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int x) {
			val = x;
		}
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

}

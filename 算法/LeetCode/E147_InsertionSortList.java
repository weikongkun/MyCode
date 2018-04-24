package com.leetCode;

import java.awt.Insets;
import java.util.List;
import java.util.Random;

public class E147_InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		ListNode head = new ListNode(4);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(3);
		
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		ListNode node = node3;
		for (int i = 0; i < 100; i++) {
			node.next = new ListNode(random.nextInt(100));
			node = node.next;
		}
		
		head = insertionSortList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		
	}
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode insertNode = head.next;
        head.next = null;
        ListNode before = null;
        ListNode after = null;
        while (insertNode != null) {
            before = null;
            after = head;
            while (after != null && after.val <= insertNode.val) {
                before = after;
                after = after.next;
            }
            if (before != null) {
                before.next = insertNode;
                insertNode = insertNode.next;
                before.next.next = after;
            }
            else {
            	ListNode node = insertNode;
            	insertNode = insertNode.next;
            	node.next = head;
            	head = node;
            }
        }
        return head;
    }

}

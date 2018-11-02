package com.leetCode;

import javax.security.auth.x500.X500Principal;

public class E328_OddEvenLinkedList {
	public static void main(String[] args) {
		E328_OddEvenLinkedList test = new E328_OddEvenLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head = test.oddEvenList(head);
		while (head != null) {
			System.out.println(head.val + " ");
			head = head.next;
		}
	}
	public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddNode = oddHead, evenNode = evenHead, node = head;
        while (node != null) {
        	oddNode.next = node;
        	oddNode = oddNode.next;
        	node = node.next;
        	
        	if (node == null) break;
        	evenNode.next = node;
        	evenNode = evenNode.next;
        	node = node.next;
        }
        evenNode.next = null;
        oddNode.next = null;
        oddNode.next = evenHead.next;
        return oddHead.next;
    }
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}

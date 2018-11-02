package com.leetCode;

public class E24_SwapNodesInPairs {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head = swapPairs(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	public static ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        if (head == null || head.next == null) return head;
        ListNode node = head, newNode = newHead, first = null, second = null;
        while (node != null && node.next != null) {
            first = node;
            second = node.next;
            node = node.next.next;
            first.next = null;
            newNode.next = second;
            newNode.next.next = first;
            newNode = newNode.next.next;
        }
        if (node != null) newNode.next = node;
        return newHead.next;
    }
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}

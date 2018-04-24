package com.leetCode;

import java.util.Random;

import com.leetCode.E147_InsertionSortList.ListNode;

public class E148_SortList {

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
		
		head = sortList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		
		ListNode head1 = head;
		ListNode head2 = slow.next;
		slow.next = null;
		head1 = sortList(head1);
		head2 = sortList(head2);
		return merge(head1, head2);
		
	}
	
	private static ListNode merge(ListNode node1, ListNode node2) {
		ListNode head = new ListNode(0);
		ListNode node = head;
		while (node1 != null || node2 != null) {
			//如果List1空，则将List2全部链接到后面；
			if (node1 == null) {
				node.next = node2;
				break;
			}
			//如果List2为空，则将List1全部链接到后面
			else if (node2 == null) {
				node.next = node1;
				break;
			}
			else {
				if (node1.val <= node2.val) {
					node.next = node1;
					node = node.next;
					node1 = node1.next;
				}
				else {
					node.next = node2;
					node = node.next;
					node2 = node2.next;
				}
			}
		}
		
		return head.next;
	}
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

}

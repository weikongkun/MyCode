package com.leetCode;

import org.w3c.dom.Node;

/**
 * <p>Title:InsertionSortList</p>
 * <p>Description:Sort a linked list using insertion sort. </p>
 * @auther Administrator
 * @data 2017年10月30日 下午8:43:00
 */
public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode();
		
		ListNode res = insertionSortList(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}

	}
	
	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode head2 = new ListNode(-1);
		head2.next = head;
		
		ListNode node1 = head.next;
		head.next = null;
		
		while (node1 != null) {
			ListNode node3 = node1;
			node1 = node1.next;
			ListNode node2 = head2;
			node3.next = null;
			while (node2.next != null) {
				if (node3.val < node2.next.val) {
					node3.next = node2.next;
					node2.next = node3;
					break;
				}
				else if (node3.val == node2.next.val) {
					node3.next = node2.next.next;
					node2.next.next = node3;
					break;
				}
				else {
					if (node2.next.next == null) {
						node2.next.next = node3;
						break;
					}
					node2 = node2.next;
				}
			}
			
		}
		
		return head2.next;
	}

}
//class ListNode {
//	int value;
//	ListNode next;
//	
//	ListNode(int x) {
//		next = null;
//		value = x;
//	}
//}

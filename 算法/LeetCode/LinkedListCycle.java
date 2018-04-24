package com.leetCode;

/**
 * <p>Title:LinkedListCycle</p>
 * <p>Description: Given a linked list, return the node where the cycle begins.
 *  If there is no cycle, return null.
    Follow up:
    Can you solve it without using extra space?</p>
 * @auther Administrator
 * @data 2017年11月8日 下午9:56:56
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node2;
//		for (int i = 10; i > 0; i--) {
//			System.out.println(node1.val);
//			node1 = node1.next;
//		}
		ListNode node = detectCycle(node1);
		System.out.println(node.val);
		
	}
	
	public static ListNode detectCycle(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		if (head == null)
			return null;
		
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				ListNode node = head;
				while (true) {
					if (node == slow) 
						return node;
					slow = slow.next;
					node = node.next;
				}
			}
				
		}
		return null;
		
	
		
		
		
	}

}

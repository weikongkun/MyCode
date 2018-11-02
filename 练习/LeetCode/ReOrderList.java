package com.leetCode;

/**
 * <p>Title:ReOrderList</p>
 * <p>Description:Given a singly linked list L: L 0→L 1→…→L n-1→L n,
	reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
	You must do this in-place without altering the nodes' values.
	For example,
	Given{1,2,3,4}, reorder it to{1,4,2,3}. </p>
 * @auther Administrator
 * @data 2017年11月2日 下午10:12:28
 */
import java.util.Stack;
public class ReOrderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		ListNode node = head;
		
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
		reorderList(head);
		node = head;
		
		int count = 10;
		System.out.println("res");
		while (node != null && count > 0) {
			System.out.println(node.val);
			count--;
		}
	
		
	}
	
	public static void reorderList(ListNode head) {
		//快慢指针
		ListNode fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			
			fast = fast.next.next;
		}
		ListNode node = slow;
		slow = slow.next;
		node.next = null;
		node = slow;
		slow = null;
		
		ListNode after;
		while (node != null) {
			after = node.next;
			node.next = slow;
			slow = node;
			node = after;
		}
		
		node = head;
		
		System.out.println("node");
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
		System.out.println("slow");
		while (slow != null) {
			System.out.println(slow.val);
			slow = slow.next;		
		}
		
		ListNode res = head;
		node = head;
		
		while (slow != null || node != null) {
			if (slow == null) {
				res.next = null;
				break;
			}
			if (node.next == null) {
				res.next = slow;
				slow.next = null;
				return;
			}
			node = node.next;
			res.next = slow;
			slow = slow.next;
			res = res.next;
			
			res.next = node;
			res = res.next;
		}
	}
	
	
}

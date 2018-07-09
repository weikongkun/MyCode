package com.leetCode;

import java.util.ArrayList;
import java.util.Stack;

public class E445_AddTwoNumbersII {
	public static void main(String[] args) {
		
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = buildStack(l1);
        Stack<Integer> s2 = buildStack(l2);
        int carry = 0;
        ListNode head = new ListNode(-1);
        while(!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
        	int x = s1.isEmpty() ? 0 : s1.pop();
        	int y = s2.isEmpty() ? 0 : s2.pop();
        	ListNode node = new ListNode((x + y + carry) % 10);
        	node.next = head.next;
        	head.next = node; 
        	carry = (x + y + carry) / 10;
        }
        return head.next;
    }
	public Stack<Integer> buildStack(ListNode head) {
		Stack<Integer> s = new Stack<>();
		while (head != null) {
			s.push(head.val);
			head = head.next;
		}
		return s;
	}
	
	private static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}

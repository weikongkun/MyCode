package com.JianZhiOffer;

import javax.xml.soap.Node;

public class E57_deleteDuplication {
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null) return null;
		ListNode node = pHead;;
		ListNode newHead = new ListNode(Integer.MAX_VALUE);
		ListNode pre = newHead;
		ListNode xNode = pre;
		pre.next = pHead;
		
		while (node != null) {
			int cnt = 0;
			int val = node.val;
			while (node != null && node.val == val) {
				cnt++;
				xNode = xNode.next;
				node = node.next;
			}
			if (cnt <= 1) {
				pre.next = xNode;
				pre = pre.next;
			}
			if (cnt > 1 && node == null) pre.next = null;
		}
		return newHead.next;
    }
	
	public ListNode deleteDuplication2(ListNode pHead) {
		if (pHead == null) return null;
		ListNode node = pHead;;
		ListNode newHead = new ListNode(Integer.MAX_VALUE);
		ListNode pre = newHead;
		ListNode xNode = pre;
		pre.next = pHead;
		
		while (node != null) {
			int cnt = 0;
			int val = node.val;
			while (node != null && node.val == val) {
				cnt++;
				xNode = xNode.next;
				node = node.next;
			}
			if (cnt <= 1) {
				pre = pre.next;
			} else {
				pre.next = node;
			}
		}
		return newHead.next;
    }
}

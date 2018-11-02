package com.JianZhiOffer;

public class E56_MeetingNode {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
//		ListNode node1 = new ListNode(1);
//		head.next = node1;
//		ListNode node2 = new ListNode(2);
//		node1.next = node2;
//		ListNode node3 = new ListNode(3);
//		node2.next = node3;
//		node3.next = node2;
		EntryNodeOfLoop(head);
	}
	public static ListNode EntryNodeOfLoop(ListNode pHead) {
		if (pHead == null) return null;
        //求出环的的节点个�?
		ListNode slow = pHead, fast = pHead.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) break;
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("fast" + fast.val + " " + "slow" + slow.val);
		//不存在环
		if (fast == null || fast.next == null) return null;
		
		int cnt = 1;
		ListNode node = slow.next;
		while (node != slow) {
			cnt++;
			node = node.next;
		}
		
		slow = pHead;fast = pHead;
		while (cnt-- > 0) fast = fast.next;
		
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println(slow.val);
		return slow;
    }

	
	
	private static class ListNode {
		int val;
		ListNode next = null;
		ListNode(int val) {
			this.val = val;
		}
	}
}

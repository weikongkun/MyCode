package com.leetCode;

public class E25_ReverseNodesInKGroup {
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node = reverseKGroup(node, 2);
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
	public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode newNode = new ListNode(-1);
        ListNode node = newNode;
        ListNode last = head;
        while (head != null) {
            System.out.println("第n次循环");
            int t = k;
            last = head;
            while (--t > 0 && last != null) last = last.next;
            if (last == null) {
                node.next = head;
                break;
            }else {
            	t = k;
                while (t-- > 0) {
                    ListNode temp = head;
                    System.out.println("加入" + temp.val);
                    head = head.next;
                    temp.next = node.next;
                    node.next = temp;
                }
                while (node.next != null) node = node.next;
            }
        }
        return newNode.next;
    }
}

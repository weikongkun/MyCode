package com.leetCode;

/**
 * <p>Title:SortList</p>
 * <p>Description: Sort a linked list in O(n log n) time using constant space complexity.</p>
 * @auther Administrator
 * @data 2017年10月29日 下午8:33:07
 */
public class SortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode header = new ListNode(2);
		header.next = new ListNode(1);
		ListNode res = sortList(header);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}
	
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		//快慢指针
		ListNode slow = head, fast = head.next;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;		
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
			}
		}
		
		ListNode ptr1 = slow.next;
		slow.next = null;
		
		ListNode temp1 = sortList(head);
		ListNode temp2 = sortList(ptr1);
		return merge(temp1, temp2);
	}
	
	public static ListNode merge(ListNode temp1, ListNode temp2) {
		ListNode head = new ListNode(-1);
		ListNode pre = head;
		while (temp1 != null && temp2 != null) {
			if (temp1.val <= temp2.val) {
				pre.next = temp1;
				temp1 = temp1.next;
				pre = pre.next;
			}
			else {
				pre.next = temp2;
				temp2 = temp2.next;
				pre = pre.next;
			}
		}
		
		while (temp1 != null) {
			pre.next = temp1;
			pre = pre.next;
			temp2 = temp1.next;
		}
		
		while (temp2 != null) {
			pre.next = temp2;
			pre = pre.next;
			temp1 = temp2.next;
		}
		
		return head.next;
	}

}

class ListNode {
	int val;
	ListNode next;
    ListNode(int x) {
    	val = x;
    	next = null;
    }
    ListNode() {
    	next = null;
    }
}

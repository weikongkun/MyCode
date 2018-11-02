package com.JianZhiOffer;

public class Eg17_MergeSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node11 = new ListNode(1);
		ListNode node12 = new ListNode(3);
		ListNode node13 = new ListNode(5);
		node11.next = node12;
		node12.next = node13;
		
		ListNode node21 = new ListNode(2);
		ListNode node22 = new ListNode(4);
		ListNode node23 = new ListNode(6);
		node21.next = node22;
		node22.next = node23;
		
		ListNode node = Merge3(node11, node21);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}

	}
	
	public static ListNode Merge(ListNode list1,ListNode list2) {
		ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode head = new ListNode(0);
        ListNode node = head;
      	
        while (node1 != null || node2 != null) {
        	if (node1 == null) {
        		node.next = node2;
        		node = node.next;
        		node2 = node2.next;
        	}
        	else if (node2 == null) {
        		node.next = node1;
        		node = node.next;
        		node1 = node1.next;
        	}
        	else if (node1.val <= node2.val) {
        		node.next = node1;
        		node = node.next;
        		node1 = node1.next;
        	}
        	else {
        		node.next = node2;
        		node = node.next;
        		node2 = node.next;
        	}
        		
        }
        
        return head.next;
    }
	
	public static ListNode Merge2(ListNode list1,ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode head = new ListNode(0);
        ListNode node = head;
      	
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
                node = node.next;
            }
            else {
                node.next = node2;
                node2 = node2.next;
                node = node.next;
            }
        }
        while (node1 != null) {
            node.next = node1;
            node1 = node1.next;
            node = node.next;
        }
        
        while (node2 != null) {
            node.next = node2;
            node2 = node2.next;
            node = node.next;
        }
        return head.next;
    }
	//ตÝน้
	public static ListNode Merge3(ListNode list1,ListNode list2) {
		if (list1 == null) return list2;
		else if (list2 == null) return list1;
		ListNode node = new ListNode(0);
		if (list1.val <= list2.val) {
			node = list1;
			node.next = Merge3(list1.next, list2);
		}
		else {
			node = list2;
			node.next = Merge3(list2.next, list1);
		}
		return node;
	}

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

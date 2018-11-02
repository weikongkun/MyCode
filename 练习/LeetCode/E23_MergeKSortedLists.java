package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.w3c.dom.ls.LSInput;

import com.leetCode.E147_InsertionSortList.ListNode;

public class E23_MergeKSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] lists = new ListNode[3];
		lists[0] = new ListNode(1);
		lists[1] = new ListNode(2);
		lists[2] = new ListNode(3);
		List<ListNode> list = Arrays.asList(lists);
		System.out.println(list.size());
	}

	public static ListNode mergeKLists1(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});
		List<ListNode> list = Arrays.asList(lists);
		ListNode head = new ListNode(0);
		ListNode node = head;
		for (int i = 0; i < list.size(); i++)
			if (list.get(i) != null)
				queue.offer(list.get(i));
		
		while (!queue.isEmpty()) {
			ListNode minNode = queue.poll();
			node.next = minNode;
			node = node.next;
			if (minNode.next != null)
				queue.offer(minNode.next);
		}
		return head.next;
		
		
	}
	
	private static ListNode minNode(ArrayList<ListNode> list) {
		Collections.sort(list, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				if (o1.val < o2.val) return -1;
				else if (o1.val > o2.val) return 1;
				else return 0;
			}
			
		});
		
		return list.get(0);
	}
	
	
	

}

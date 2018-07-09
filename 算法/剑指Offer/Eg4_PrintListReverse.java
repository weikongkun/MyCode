package com.JianZhiOffer;
import java.util.*;
public class Eg4_PrintListReverse {
	public static void main(String[] args) {
		
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> s = new Stack<>();
		ListNode node = listNode;
		while (node != null) {
			s.push(node.val);
			node = node.next;
		}
		ArrayList<Integer> al = new ArrayList<>();
		while (!s.isEmpty()) 
			al.add(s.pop());
		return al;
	}
	
	private class ListNode {
		private int val;
		private ListNode next = null;
		private ListNode(int val) {
			this.val = val;
		}
	}
}

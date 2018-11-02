package com.LRUCache;
import java.util.HashMap;

public class LRUCache {
	private int capacity;
	private Node head;
	private Node tail;
	private HashMap<Integer, Node> map;
	LRUCache(int capacity) {
		this.capacity = capacity;
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.pre = head;
		map = new HashMap<>();
	}
	int get(int val) {
		Node node = map.get(val);
		if (node == null) return -1;
		node.pre.next = node.next;
		node.next.pre = node.pre;
		node.next = head.next;
		head.next.pre = node;
		head.next = node;
		node.pre = head;
		return node.val;
	}
	void put(int key, int val) {
		Node node = map.get(key);
		if (node != null) {
			node.val = val;
			node.pre.next = node.next;
			node.next.pre = node.pre;
			node.next = head.next;
			head.next.pre = node;
			head.next = node;
			node.pre = head;
			return;
		}
		if (map.size() == capacity) {
			Node temp = tail.pre;
			temp.next.pre = temp.pre;
			temp.pre.next = temp.next;
			temp.next = null;
			temp.pre = null;
			map.remove(temp.key);
		}
		node = new Node(key, val);
		map.put(key, node);
		head.next.pre = node;
		node.next = head.next;
		head.next = node;
		node.pre = head;
	}
	private static class Node {
		int key;
		int val;
		Node next;
		Node pre;
		Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}
}


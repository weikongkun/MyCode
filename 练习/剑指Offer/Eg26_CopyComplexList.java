package com.JianZhiOffer;

public class Eg26_CopyComplexList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.next.next = new RandomListNode(3);
		head.next.next.next = new RandomListNode(4);
		Clone(head);
	}
	
	public static RandomListNode Clone(RandomListNode pHead) {
		RandomListNode copyHead = null;
		if (pHead == null) return null;
		cloneNode(pHead, copyHead);
//		RandomListNode node = pHead;
//		while (node != null) {
//			System.out.println(node.label + " ");
//			node = node.next;
//		}
		copyRandomList(pHead, copyHead);
//		node = pHead;
//		while (node != null) {
//			System.out.println(node.label + " ");
//			node = node.next;
//		}
		reConnectNodes(pHead);
		return copyHead;
	}
	
	public static void cloneNode(RandomListNode pHead, RandomListNode copyHead) {		
		RandomListNode node = pHead, copyNode = copyHead;
		while (node != null) {
			copyNode = new RandomListNode(node.label);
			copyNode.next = node.next;
			node.next = copyNode;
			node = copyNode.next;
		}
	}
	
	public static void copyRandomList(RandomListNode pHead, RandomListNode copyHead) {
		RandomListNode node = pHead;
		while (node != null) {
			if (node.random != null)
				node.next.random = node.random.next;
			node = node.next.next;
		}
	}
	
	public static RandomListNode reConnectNodes(RandomListNode pHead) {
		RandomListNode node = pHead, copyNode = pHead.next, head = copyNode;
		System.out.println(node == node.next);
		
		while (node != null) {
			node.next = copyNode.next;
			node = node.next;
			if (node != null) {
				copyNode.next = node.next;
				copyNode = node.next;
			}
		}
		System.out.println(pHead == head);
		System.out.println(pHead.label + head.label);
		return head;
	}
	
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}



package com.JianZhiOffer;

public class Eg45_lastNumberInCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(LastRemaining_Solution(5, 3));

	}
	public static int LastRemaining_Solution(int n, int m) {
        ListNode node0 = new ListNode(0);
        ListNode node = node0;
        for (int i = 1; i < n; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode printnode = node0;
        while (printnode != null) {
//        	System.out.print(printnode.val);
        	printnode = printnode.next;
        }
//        System.out.println();
        node.next = node0;
        
        ListNode preOfDeleteNode = node;
        ListNode deleteNode = node0;
        ListNode afterDeleteNode = node0.next;
        while (!deleteNode.next.equals(deleteNode)) {
            for (int i = 1; i <= m - 1; i++) {
                deleteNode = deleteNode.next;
                preOfDeleteNode = preOfDeleteNode.next;
                afterDeleteNode = afterDeleteNode.next;
            }
//            System.out.print("Delete: " + deleteNode.val);
//            System.out.print("  " + "PreNum" + preOfDeleteNode.val +" AfterNum" + afterDeleteNode.val);
            preOfDeleteNode.next = afterDeleteNode;
            deleteNode = afterDeleteNode;
            afterDeleteNode = afterDeleteNode.next;
//            System.out.println("  " + "PreNum" + preOfDeleteNode.val +" AfterNum" + afterDeleteNode.val);
            
        }
        return deleteNode.val;
            
    }
	
	static class ListNode {
		int val;
		ListNode next = null;
		ListNode(int val) {
			this.val = val;
		}
	}
   
}



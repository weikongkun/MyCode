package JianZhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class Eg7_StackOfTwoQueue {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
			
	
	public void push(int node) {
		q1.add(node);
	}
	public int pop() {
		while (q1.size() > 1)
			q2.add(q1.remove());
		int v = q1.remove();
		while (!q2.isEmpty())
			q1.add(q2.remove());
		return v;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	Eg7_StackOfTwoQueue eg7 = new Eg7_StackOfTwoQueue();
	eg7.push(1);
	eg7.push(2);
	eg7.push(3);
	System.out.println(eg7.pop());
	System.out.println(eg7.pop());
	eg7.push(4);
	System.out.println(eg7.pop());
	eg7.push(5);
	System.out.println(eg7.pop());
	System.out.println(eg7.pop());
	}

}

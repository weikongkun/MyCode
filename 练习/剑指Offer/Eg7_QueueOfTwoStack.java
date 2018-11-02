package com.JianZhiOffer;

import java.util.Stack;

public class Eg7_QueueOfTwoStack {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
//    	while (!stack1.isEmpty())
//    		stack2.push(stack1.pop());
//    	int v = stack2.pop();
//    	while (!stack2.isEmpty())
//    		stack1.push(stack2.pop());
//    	return v;
    	if (stack2.isEmpty())
    		while (!stack1.isEmpty())
    			stack2.push(stack1.pop());
    	return stack2.pop();
    }
    public static void main(String[] args) {
    	Eg7_QueueOfTwoStack eg7 = new Eg7_QueueOfTwoStack();
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

package com.JianZhiOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;


public class E65_maxInWindows {
	public ArrayList<Integer> maxInWindows(int [] num, int size) {
        int m = num.length;
        int index = -1;
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        for (int i = 0; i < m - size + 1; i++) {
        	if (index < i) {
        		index = i;
        		for (int j = i + 1; j < size + i; j++) {
        			if (num[j] >= num[index]) {
        				index = j;
        			}
        		}
        		res.add(num[index]);
        	}
        	else {
        		if (num[index] <= num[i + size - 1]) {
        			index = i + size - 1;
        		}
        		res.add(num[index]);
        	}
        }
        return res;
    }
	
	public ArrayList<Integer> maxInWindows2(int [] num, int size) {
        int m = num.length;
        ArrayList<Integer> list = new ArrayList<>();
        if (size > num.length || size == 0) return list;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < size; i++) {
        	while (!deque.isEmpty() && num[i] >= num[deque.peekLast()])
        		deque.removeLast();
        	deque.addLast(i);
        }
        
        for (int i = size; i < num.length; i++) {
        	list.add(num[deque.getFirst()]);
        	while (!deque.isEmpty() && num[i] >= num[deque.getLast()])
        		deque.removeLast();
        	if (!deque.isEmpty() && deque.getFirst() <= (i - size))
        		deque.removeFirst();
        	deque.addLast(i);
        }
        list.add(num[deque.getFirst()]);
        return list;
    }
	
}

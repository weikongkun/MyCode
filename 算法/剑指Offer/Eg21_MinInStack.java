package JianZhiOffer;

import java.util.ArrayList;

public class Eg21_MinInStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		
		s.push(3);
		System.out.println(s.min());
		s.push(4);
		System.out.println(s.min());
		s.push(2);
		System.out.println(s.min());
		s.push(3);
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.push(0);
		System.out.println(s.min());
	}

}

class Solution {
    ArrayList<Integer> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
    
    public void push(int node) {
        list1.add(node);
        if (list1.size() == 1)
            list2.add(node);
        else {
            if (list2.get(list2.size() - 1) > node)
                list2.add(node);
            else
                list2.add(list2.get(list2.size() - 1));
        }
    }
    
    
    public void pop() {
        list1.remove(list1.size() - 1);
        list2.remove(list2.size() - 1);
    }
    
    public int top() {
        return list1.get(list1.size() - 1);
    }
    
    public int min() {
        return list2.get(list2.size() - 1);
    }
}

package JianZhiOffer;

import java.util.Stack;

public class Eg22_StackPushPopOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4,5};
		int[] B = {4,5,3,2,1};
		System.out.println(IsPopOrder(A, B));

	}

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> s = new Stack<>();
		for (int i = pushA.length - 1, j = i; j >= 0; j--) {
			while ((s.size() == 0 || s.peek() != pushA[j])) {
				if (i < 0)
					return false;
				s.push(popA[i]);
				i--;
			}
			s.pop();
		}
		if (s.size() == 0)
			return true;
		else
			return false;
	}

}

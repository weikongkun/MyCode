package com.NK;
import java.util.*;

public class Main01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int N = 0, k = 0;
		
		int count = 0;
		
		while (in.hasNext()) {
			N = in.nextInt();
			for (int i = 0; i < N; i++) {
			   list.add(in.nextInt());
			}
			k = in.nextInt();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - i; j++) {
					if (sum(list, i, j+1) % k == 0 && j + 1 - i > count) {
						count = j + 1 - i;
					}
				}
			}
			
			System.out.println(count);
		}
		
		
	}
	
	public static int sum(ArrayList<Integer> list, int i, int j) {
		int sum = 0;
		for (int t = i; t < i + j; t++) {
			sum = sum + list.get(t);
		}
		
		return sum;
		
	}

}

package com.NK;
import java.util.*;

public class randomMing {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		
		int num = input.nextInt();
		for (int i = 0; i < num; i++) {
			set.add(input.nextInt());
		}
		
		for (Integer value1: set) {
			list.add(value1);
		}
		Collections.sort(list);
		for (Integer value2: list) {
			System.out.println(value2);
		}
	}
}

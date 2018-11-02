package com.NK;
import java.util.Scanner;
import java.util.Stack;
import java.util.HashSet;

public class Main03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str0 = in.nextLine();
		String str1 = null;
		String str2 = null;
		
		int size = str0.length();
		HashSet<String> set = new HashSet<>();
		int count = 0;
		
		for (int i = 0; i < size; i++) {
			char ch = str0.charAt(i);
			str1 = null;
			str2 = null;
			str1 = str0.substring(0, i) + str0.substring(i + 1, size);
			for (int j = 1; j < str1.length(); j++) {
				str2 = str1.substring(0, j) + String.valueOf(ch) + str1.substring(j, str1.length());
				if (!set.contains(str2) && isLegal(str2)) {
					set.add(str2);
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	public static boolean isLegal(String str) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == ')')
				return false;
			s.push(ch);
			if (ch == ')') {
				s.pop();
				s.pop();
			}
		}
		
		if (s.isEmpty())
			return true;
		return false;
	}

}

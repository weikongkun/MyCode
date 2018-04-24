package com.NK;

import java.util.Scanner;

public class Main15 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) >= 'a'&& str.charAt(i) < 'z') || (str.charAt(i) >= 'A'&& str.charAt(i) < 'Z'))
				res.append((char)(str.charAt(i) + 1));
			else if (str.charAt(i) == 'z') 
				res.append('a');
			else if (str.charAt(i) == 'Z') 
				res.append('A');
			else 
				res.append(str.charAt(i));
		}
		System.out.println(res.toString());
	}
}

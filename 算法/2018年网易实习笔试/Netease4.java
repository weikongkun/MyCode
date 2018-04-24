package com.netease;

import java.util.Scanner;

public class Netease4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		String str = in.next();
		int numOfL = 0;
		int numOfR = 0;
		for (int i = 0; i < num; i++) {
			if (str.charAt(i) == 'L') numOfL++;
			else numOfR++;
		}
		
		int L = numOfL % 4;
		int R = numOfR % 4;
		R = 4 - L + R;
		R %= 4;
		char res = 0;
		if (R == 0) res = 'N';
		else if (R == 1) res = 'E';
		else if (R == 2) res = 'S';
		else res = 'W';
		System.out.println(res);
	}

}

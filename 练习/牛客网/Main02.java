package com.NK;
import java.util.Scanner;
import java.lang.Math;

public class Main02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String str = in.nextLine();
			double ans = 0;
			for (int i = 2; i < str.length(); i++) {
				if (str.charAt(i) == 'A')
					ans = ans + 10.0 * Math.pow(16, str.length() - i - 1); 
				else if (str.charAt(i) == 'B')
					ans = ans + 11.0 * Math.pow(16, str.length() - i - 1); 
				else if (str.charAt(i) == 'C')
					ans = ans + 12.0 * Math.pow(16, str.length() - i - 1); 
				else if (str.charAt(i) == 'D')
					ans = ans + 13.0 * Math.pow(16, str.length() - i - 1); 
				else if (str.charAt(i) == 'E')
					ans = ans + 14.0 * Math.pow(16, str.length() - i - 1); 
				else if (str.charAt(i) == 'F')
					ans = ans + 15.0 * Math.pow(16, str.length() - i - 1); 
				else 
					ans =ans + (str.charAt(i) - '0') * Math.pow(16, str.length() - i - 1);
			}
			
			System.out.println((int)ans);
			
		}
		
		
	}

}

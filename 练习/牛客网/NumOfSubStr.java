package com.NK;
import java.util.Scanner;

public class NumOfSubStr {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    String str1 = null;
	    String str2 = null;
	    
	    str1 = in.nextLine();
	    str2 = in.nextLine();
	    
	    char char0 = str2.charAt(0);
	    int count = 0;
	    
	    for (int i = 0; i < str1.length(); i++) {
	    	if (!((char0 >= 'A' && char0 <= 'Z') || (char0 >= 'a' && char0 <= 'z')) && char0 == str1.charAt(i)) {
	    		count++;
	    	}
	    	if ((char0 >= 'A' && char0 <= 'Z') || (char0 >= 'a' && char0 <= 'z') && (char0 == str1.charAt(i) || char0 == str1.toUpperCase().charAt(i)) || char0 == str1.toLowerCase().charAt(i)) {
	    		count++;
	    	}
	    }
	    
	    System.out.println(count);
	}
}

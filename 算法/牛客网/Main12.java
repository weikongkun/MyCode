package com.NK;

import java.util.Arrays;
/**
 * <p>Title:Main12</p>
 * <p>Description: 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母</p>
 * @auther Administrator
 * @data 2017年12月6日 下午10:11:14
 */
import java.util.Scanner;
public class Main12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int n = Integer.parseInt(in.nextLine());
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = in.nextLine();
		}
		
//		for (int i = 0; i < strs.length; i++)
//			System.out.println(strs[i]);
		
		sort(strs);
	}
	
	public static void sort(String[] strs) {
		for (int i = 0; i < strs.length; i++) 
			for (int j = 0; j < strs.length - 1 - i; j++) {
				String temp = null;
				if (!isSort(strs[j], strs[j + 1])) {
					temp = strs[j];
					strs[j] = strs[j + 1];
					strs[j + 1] = temp;
				}
			}
		
		for (int i = 0; i < strs.length; i++) 
			System.out.println(strs[i]);
	}
	
	public static boolean isSort(String str1, String str2) {
		int i = 0;
		while (i < str1.length() && i < str2.length()) {
			if (Character.isLowerCase(str1.charAt(i)) && Character.isUpperCase(str2.charAt(i)))
				return false;
			if (Character.isUpperCase(str1.charAt(i)) && Character.isLowerCase(str2.charAt(i)))
				return true;
			if (str1.charAt(i) < str2.charAt(i))
				return true;
			else if (str1.charAt(i) > str2.charAt(i))
				return false;
			i++;
		}
		
		if (i == str1.length())
			return true;
		else
			return false;
	}
	


}

package com.NK;

/**
 * <p>Title:Main8</p>
 * <p>Description: ��дһ�������������ַ����к��еĲ�ͬ�ַ��ĸ������ַ���ACSII�뷶Χ��(0~127)�����ڷ�Χ�ڵĲ���ͳ��</p>
 * @auther Administrator
 * @data 2017��10��23�� ����10:43:23
 */
import java.util.Scanner;
import java.util.HashSet;
public class Main08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.next();
		
		int count = str.length();
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			if (set.contains(str.charAt(i)))
				count--;
			set.add(str.charAt(i));
		}
		
		System.out.println(count);
	}
	
	

}

package com.NK;

/**
 * <p>Title:Main11</p>
 * <p>Description: ��һ��Ӣ������Ե���Ϊ��λ�����ŷš����硰I am a boy���������ŷź�Ϊ��boy a am I��
���е���֮����һ���ո����������г���Ӣ����ĸ�⣬���ٰ��������ַ�</p>
 * @auther Administrator
 * @data 2017��12��6�� ����9:27:36
 */

import java.util.Scanner;
import java.util.LinkedList;


public class Main11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		System.out.println(reverse(str));
		
	}
	
	public static String reverse(String sentence) {
		
		String[] strs = sentence.split(" ");
		
		StringBuffer sb = new StringBuffer();
		for (int i = strs.length - 1; i >= 0; i--)  {
			sb.append(strs[i]);
			sb.append(" ");
		}
		sb.append(strs[0]);
		
		return sb.toString();
	}
}

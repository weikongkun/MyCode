package com.NK;

/**
 * <p>Title:Main9</p>
 * <p>Description:����һ��������������������ַ�������ʽ�������
���򲻿��Ǹ���������������ֺ���0����������ʽҲ����0��������Ϊ100�������Ϊ001 </p>
 * @auther Administrator
 * @data 2017��10��26�� ����11:11:59
 */
import java.util.Scanner;

public class Main09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		String str = "";
		while (num > 0) {
			str += (num % 10);
			num = num / 10;
		}
		
		System.out.println(str);
	}

}

package com.NK;

/**
 * <p>Title:Main5</p>
 * <p>Description: д��һ�����򣬽���һ����������ֵ���������ֵ�Ľ�������ֵ�����С�������ֵ���ڵ���5,����ȡ����С��5��������ȡ����</p>
 * @auther Administrator
 * @data 2017��10��12�� ����10:05:46
 */
import java.util.Scanner;

public class Main05 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double dou = in.nextDouble();
		
		String str = dou + "";
		int num = (int)dou; 
		if (str.charAt(str.indexOf('.') + 1) >= '5')
			num += 1;
			
		
		
		
		System.out.println(num);
	}
}

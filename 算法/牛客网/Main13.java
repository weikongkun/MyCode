package com.NK;

/**
 * <p>Title:Main13</p>
 * <p>Description: ����һ��int�͵����������������int���������ڴ��д洢ʱ1�ĸ�����</p>
 * @auther Administrator
 * @data 2017��12��7�� ����10:30:35
 */
import java.util.Scanner;
public class Main13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int count = 0;
		
		
		while (n != 0) {
			if (n % 2 == 1)
				count++;
			n /= 2;
		}
		
		System.out.println(count);
			

	}

}

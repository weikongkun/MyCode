package com.NK;

import java.util.Arrays;
import java.util.Scanner;

public class Main04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext())
			System.out.println(getResult(in.nextLong()));

	}
	
	/**
	 * <p>Description:����:����һ�������������մ�С�����˳����������������������ӣ���180����������Ϊ2 2 3 3 5 ��
     *                    ���һ��������ҲҪ�пո�</p>
	 * @auther Administrator
	 * @data 2017��10��11�� ����10:40:40
	 * @return string
	 */
	public static String getResult(long ulDataInput) {
		String ans = "";
		
		int i = 2;
		while (true) {
			if (ulDataInput % i == 0) {
				if (ulDataInput == i) {
					ans = ans + i + " ";
					break;
				}
				else {
					ans = ans + i + " ";
					ulDataInput /= i;
				}
			}
			else
				i++;
		}
		return ans;
			
	}

}

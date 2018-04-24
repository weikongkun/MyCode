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
	 * <p>Description:功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
     *                    最后一个数后面也要有空格</p>
	 * @auther Administrator
	 * @data 2017年10月11日 下午10:40:40
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

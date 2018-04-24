package com.NK;

/**
 * <p>Title:Main9</p>
 * <p>Description:输入一个整数，将这个整数以字符串的形式逆序输出
程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001 </p>
 * @auther Administrator
 * @data 2017年10月26日 上午11:11:59
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

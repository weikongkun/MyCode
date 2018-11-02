package com.NK;

/**
 * <p>Title:Main10</p>
 * <p>Description: 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。</p>
 * @auther Administrator
 * @data 2017年10月29日 下午8:25:33
 */
import java.util.Scanner;

public class Main10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		String result = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		
		System.out.println(result);
	}

}

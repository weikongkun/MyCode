package com.NK;

/**
 * <p>Title:Main8</p>
 * <p>Description: 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计</p>
 * @auther Administrator
 * @data 2017年10月23日 下午10:43:23
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

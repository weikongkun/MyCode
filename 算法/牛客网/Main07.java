package com.NK;

/**
 * <p>Title:Main7</p>
 * <p>Description: 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。</p>
 * @auther Administrator
 * @data 2017年10月14日 上午10:21:41
 */
import java.util.Scanner;
import java.util.*;

public class Main07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		Set<Integer> set = new HashSet<>();
		String str = "";
		while (num != 0) {
			int  i = num % 10;//最后一位数
			num /= 10;
			if (!set.contains(i)) {
				str = str + i;
				set.add(i);
			}
		}
		
		System.out.println(Integer.parseInt(str));
	}

}

package com.NK;

/**
 * <p>Title:Main13</p>
 * <p>Description: 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。</p>
 * @auther Administrator
 * @data 2017年12月7日 下午10:30:35
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

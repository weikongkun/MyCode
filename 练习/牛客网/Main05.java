package com.NK;

/**
 * <p>Title:Main5</p>
 * <p>Description: 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。</p>
 * @auther Administrator
 * @data 2017年10月12日 下午10:05:46
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

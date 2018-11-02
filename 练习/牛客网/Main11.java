package com.NK;

/**
 * <p>Title:Main11</p>
 * <p>Description: 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符</p>
 * @auther Administrator
 * @data 2017年12月6日 下午9:27:36
 */

import java.util.Scanner;
import java.util.LinkedList;


public class Main11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		System.out.println(reverse(str));
		
	}
	
	public static String reverse(String sentence) {
		
		String[] strs = sentence.split(" ");
		
		StringBuffer sb = new StringBuffer();
		for (int i = strs.length - 1; i >= 0; i--)  {
			sb.append(strs[i]);
			sb.append(" ");
		}
		sb.append(strs[0]);
		
		return sb.toString();
	}
}

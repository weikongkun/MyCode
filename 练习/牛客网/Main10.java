package com.NK;

/**
 * <p>Title:Main10</p>
 * <p>Description: д��һ�����򣬽���һ���ַ�����Ȼ��������ַ�����ת����ַ�����</p>
 * @auther Administrator
 * @data 2017��10��29�� ����8:25:33
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

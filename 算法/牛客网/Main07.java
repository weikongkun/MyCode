package com.NK;

/**
 * <p>Title:Main7</p>
 * <p>Description: ����һ��int�����������մ���������Ķ�˳�򣬷���һ�������ظ����ֵ��µ�������</p>
 * @auther Administrator
 * @data 2017��10��14�� ����10:21:41
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
			int  i = num % 10;//���һλ��
			num /= 10;
			if (!set.contains(i)) {
				str = str + i;
				set.add(i);
			}
		}
		
		System.out.println(Integer.parseInt(str));
	}

}

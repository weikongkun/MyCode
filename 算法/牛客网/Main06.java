package com.NK;

/**
 * <p>Title:Main6</p>
 * <p>Description:���ݱ��¼��������������ֵ����Ա�������ͬ�ļ�¼���кϲ���������ͬ��������ֵ����������㣬�������keyֵ������������ </p>
 * @auther Administrator
 * @data 2017��10��13�� ����9:50:47
 */
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map.Entry;
public class Main06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int n = in.nextInt();
		int key, value;
		for (int i = 0; i < n; i++) {
			key = in.nextInt();
			value = in.nextInt();
			
			if (map.containsKey(key)) {
				map.put(key, value + map.get(key));
			}
			else
				map.put(key, value);
		}
		
		Set<Entry<Integer, Integer>> set = map.entrySet();
		for(Entry<Integer, Integer> entry: set) {
			System.out.println(entry.getKey().intValue() + " " + entry.getValue().intValue());
		}
	}

}

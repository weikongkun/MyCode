package com.NK;

/**
 * <p>Title:Main6</p>
 * <p>Description:数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。 </p>
 * @auther Administrator
 * @data 2017年10月13日 下午9:50:47
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

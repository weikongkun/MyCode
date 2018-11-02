package com.netease;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Netease1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();//工作数量
		int M = in.nextInt();//小伙伴数量
		int[] Di = new int[N + M];//工作难度
		int[] ability = new int[M];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			Di[i] = in.nextInt();
			map.put(Di[i], in.nextInt());
		}
		for (int i = N; i < N + M; i++) {
			Di[i] = in.nextInt();
			int val = map.containsKey(Di[i]) ? map.get(Di[i]) : 0;
			map.put(Di[i], val);
			ability[i - N]  = Di[i];
		}
		Arrays.sort(Di);
		for (int i = 1; i < Di.length; i++) {
			map.put(Di[i], Math.max(map.get(Di[i - 1]), map.get(Di[i])));
		}
		for (int i = 0; i < M; i++) {
			System.out.println(map.get(ability[i]));
		}
		in.close();
		
	}

}

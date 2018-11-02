package com.NK;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * 
 *@ClassName: Main16
 *@Description: 最小生成树 kuskal算法,case没有全部通过，利用并查集
 *@date：      2018年3月22日 下午4:08:05
 */
public class Main16 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();//N块空地
		int M = in.nextInt();//M行,
		
	
		int[] a = new int[N + 1];
		for (int i = 0; i <= N; i++) 
			a[i] = i;
		
		PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.weight - o1.weight;
			}
			
		});
		
		
		for (int i = 0; i < M; i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			int weight = in.nextInt();
			queue.offer(new Edge(v, w, weight));
		}
		int res = 0;
		
		while (!queue.isEmpty()) {
			Edge e = queue.poll();
			System.out.println(e.weight);
			int f1 = father(e.v, a);
			int f2 = father(e.w, a);
			if (f1 != f2) {
				if (res < e.weight) 
					res = e.weight;
				if (f1 < f2)
					a[f1] = f2;
				else 
					a[f2] = a[f1];
			}
		}
		
		System.out.println(res);
	}
	
	public static int father(int i, int[] a) {
		int k = i;
		return a[k] == k ? k : father(a[k], a);
	}
	static class Edge {
		int v;
		int w;
		int weight;
		Edge(int v, int w, int weight){
			this.v = v;
			this.w = w;
			this.weight = weight;
		}
	}
	
}

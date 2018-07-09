package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class E210_CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = buildGraph(numCourses, prerequisites);
		if (hasCycle(graph)) return new int[] {};
		Stack<Integer> reversePost = new Stack<>();
		boolean[] marked = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (!marked[i]) dfspost(graph, i, reversePost, marked);
		}
		int[] res = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
			res[i] = reversePost.pop();
		return res;
    }
	private void dfspost(List<Integer>[] graph, int index, Stack<Integer> stack, boolean[] marked) {
		marked[index] = true;
		if (graph[index] != null) {
			for (int id : graph[index]) 
				if (!marked[id]) dfspost(graph, id, stack, marked);
		}
		stack.push(index);
	}
	private List<Integer>[] buildGraph(int numCourses, int[][] data) {
		List<Integer>[] res = new ArrayList[numCourses];
		System.out.println("Graph：");
		
		for (int[] nums : data) {
			int start = nums[1];
			int end = nums[0];
			if (res[start] == null) res[start] = new ArrayList<>();
			res[start].add(end);
		}
		System.out.println("*****************************");
		for (List<Integer> list : res) System.out.println(list);
		System.out.println("******************************");
		return res;
	}
	private boolean hasCycle(List<Integer>[] graph) {
		int N = graph.length;
		boolean[] marked = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (graph[i] == null) continue;
			if (dfs(graph, i, marked)) return true;
		}
		return false;
	}
	
	private boolean dfs(List<Integer>[] graph, int i, boolean[] marked) {
		if (graph[i] == null) return false;
		if (marked[i] == true) return true;
		List<Integer> list = graph[i];
		marked[i] = true;
		for (int id : list) {
			if (dfs(graph, id, marked)) return true;
		}
		marked[i] = false;
		return false;
	}
}

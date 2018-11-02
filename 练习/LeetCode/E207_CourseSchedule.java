package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class E207_CourseSchedule {
	public static void main(String[] args) {
		int numCourses = 3;
		int[][] pre = {{0, 1}, {0, 2}, {1, 2}};
		System.out.println(new E207_CourseSchedule().canFinish(numCourses, pre));
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        System.out.println("HasCycle: " + hasCycle(graph));
        System.out.println("----------------------");
        return !hasCycle(graph);
    }
	private List<Integer>[] buildGraph(int numCourses, int[][] data) {
		List<Integer>[] res = new ArrayList[numCourses];
		System.out.println("Graph：");
		
		for (int[] nums : data) {
			int start = nums[0];
			int end = nums[1];
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

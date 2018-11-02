package com.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class E785_IsGraphBipartite {
	public boolean isBipartite(int[][] graph) {
		int N = graph.length;
		for (int i = 0; i < N; i++) {
			if (!slove(graph, i)) return false;
		}
		return true;
    }
	public boolean slove(int[][] graph, int i) {
		int N = graph.length;
        char[] nodes = new char[N];
        Arrays.fill(nodes, '0');
        Queue<Integer> q = new LinkedList<>();
        q.add(i);nodes[i] = 'Y';
        while (!q.isEmpty()) {
            int v = q.poll();
            int color = nodes[v];
            for(int x : graph[v]) {
                if (nodes[x] == (color == 'Y' ? 'N' : 'Y')) {
                	continue;
                }
                else if (nodes[x] == color) return false;
                else {
                	nodes[x] = (color == 'Y' ? 'N' : 'Y');
                	q.add(x);
                }
            }
        }
        return true;
	}
}

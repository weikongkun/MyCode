package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class E757_SetIntersectionSizeAtLeastTwo {
	public int intersectionSizeTwo(int[][] intervals) {
		int res = 0;
		List<Interval> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) 
			list.add(new Interval(intervals[i][0], intervals[i][1]));
		Collections.sort(list, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		return res;
	}
	class Interval {
		int a;
		int b;
		Interval(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}

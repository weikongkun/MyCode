package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class E56_MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> ret = new ArrayList<>();
		if (intervals == null || intervals.isEmpty()) return ret;
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start != o2.start ? o1.start - o2.start : o1.end - o2.end;
			}
		});
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start <= end) {
				if (intervals.get(i).end <= end) continue;
				end = intervals.get(i).end;
			}
			else {
				ret.add(new Interval(start, end));
				start = intervals.get(i).start;
				end = intervals.get(i).end;
			}
		}
		ret.add(new Interval(start, end));
		return ret;
	}

	private class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}

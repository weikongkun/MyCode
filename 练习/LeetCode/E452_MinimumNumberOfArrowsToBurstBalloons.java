package com.leetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class E452_MinimumNumberOfArrowsToBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) return 0;
		Point[] points2 = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
        	points2[i] = new Point(points[i][0], points[i][1]);
        }
        Arrays.sort(points2, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.end - o2.end;
			}
		});
        int end = points2[0].end;
        int cnt = 1;
        for (int i = 1; i < points2.length; i++) {
        	if (points2[i].start > end) {
        		cnt++;
        		end = points2[i].end;
        	}
        }
        return cnt;
    }
	
	private static class Point {
		int start;
		int end;
		Point(int start, int end) {
			this.end = end;
			this.start = start;
		}
	}
}

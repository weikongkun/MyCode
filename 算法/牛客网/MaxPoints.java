package com.NK;
import java.util.ArrayList;
/**
 * <p>Title:MaxPoints</p>
 * <p>Description: Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.</p>
 * @auther Administrator
 * @data 2017年10月15日 上午10:23:17
 */
public class MaxPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = new Point[] {
			new Point(0, 0), new Point(0, 0)
		};
		
		System.out.println(maxPoints(points));
	}
	
	public static int maxPoints(Point[] points) {
		ArrayList<Point> list = new ArrayList<>();
		int count = 2;
		if (points.length <= 2)
			return points.length;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				list.clear();
				list.add(points[i]);
				
				if (points[i].x == points[j].x && points[i].y!= points[j].y) {
					list.add(points[j]);
					for (int k = j + 1; k < points.length; k++)
						if (points[k].x == points[i].x)
							list.add(points[k]);
					count = (count > list.size()) ? count : list.size();
				}
				else if (points[i].y == points[j].y && points[i].x != points[j].x) {
					list.add(points[j]);
					for (int k = j + 1; k < points.length; k++)
						if (points[k].y == points[i].y)
							list.add(points[k]);
					count = (count > list.size()) ? count : list.size();
				}
				else {
					while (j < points.length) {
						if (points[i].x == points[j].x && points[i].y == points[j].y) {
							list.add(points[j]);
							if (j == points.length - 1)
								break;
							j++;
						}
						else {
							list.add(points[j]);
							break;
						}
					}
					double slope = (points[j].y - points[i].y) / (points[j].x - points[i].x);
					for (int k = j + 1; k < points.length; k++) 
						if ((points[k].y - points[i].y) / (points[k].x - points[i].x) == slope || (points[k].y - points[j].y) / (points[k].x - points[j].x) == slope)
							list.add(points[k]);
					count = (count > list.size()) ? count : list.size();
				}
			}
		}
		return count;
		
	}
	


}

class Point {
	double x;
	double y;
	
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

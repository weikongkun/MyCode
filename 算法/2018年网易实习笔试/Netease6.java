package com.netease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Netease6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		ArrayList<Integer> x1 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			x1.add(in.nextInt());
		}
		ArrayList<Integer> y1 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			y1.add(in.nextInt());
		}
		ArrayList<Integer> x2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			x2.add(in.nextInt());
		}
		ArrayList<Integer> y2 = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			y2.add(in.nextInt());
		}
		
		ArrayList<Rectangle> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(new Rectangle(x1.get(i), y1.get(i), x2.get(i), y2.get(i)));
		}
//		System.out.println(list);
		
		
		HashSet<Integer> xSet = new HashSet<>();
		xSet.addAll(x1); xSet.addAll(x2);
		HashSet<Integer> ySet = new HashSet<>();
		ySet.addAll(y1); ySet.addAll(y2);
		
		ArrayList<Integer> xList = new ArrayList<>(); xList.addAll(xSet);
		ArrayList<Integer> yList = new ArrayList<>(); yList.addAll(ySet);
		
		Collections.sort(xList);
		Collections.sort(yList);
		int res = 0;
		
		for (int i = 0; i < xList.size() - 1; i++) {
			for (int j = 0; j < yList.size() - 1; j++) {
				double xcentral = (xList.get(i) + xList.get(i + 1)) / 2.0;
				double ycentral = (yList.get(i) + yList.get(i + 1)) / 2.0;
				int count = 0;
				for (int k = 0; k < list.size(); k++)
					if (list.get(k).isContainPoint(xcentral,ycentral)) count++;
				if (count > res) res = count;
			}
		}
		System.out.println(res);
	}
}

class Rectangle {
	int x1;
	int y1;
	int x2;
	int y2;
	public Rectangle(int x1, int y1, int x2, int y2) { 
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	public boolean isContainPoint(double x, double y) {
		if (x < x2 && x > x1 && y < y2 && y > y1)
			return true;
		else 
			return false;
	}
	public String toString() {
		return "[" + x1 + "," + y1 + "," + x2 + "," + y2 + "]";
	}
}

package com.JianZhiOffer;

import java.util.ArrayList;

public class Eg34_UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ans = GetUglyNumber_Solution(10);
		System.out.println(ans);
	}
	
	public static ArrayList<Integer> GetUglyNumber_Solution(int index) {
       
        ArrayList<Integer> list = new ArrayList<>();
        if (index < 1) return list;
        list.add(0);
        list.add(1);
        int t2 = 0, t3 = 0, t5 = 0;
        
        while (list.size() != index + 1) {
        	//乘以2后第一个大于最大值的索引i
        	int i = t2;
        	while (2 * list.get(i) <= list.get(list.size() - 1))
        		i++;
        	t2 = i;
        	//乘以3后第一个大于最大值的索引
        	int j = t3;
        	while (3 * list.get(j) <= list.get(list.size() - 1))
        		j++;
        	t3 = j;
        	//乘以5后第一个大于最大值的索引
        	int k = t5;
        	while (5 * list.get(k) <= list.get(list.size() - 1))
        		k++;
        	t5 = k;
        	
        	list.add(Math.min(Math.min(2 * list.get(i), 3 * list.get(j)), 5 * list.get(k)));	
        }
        list.remove(0);
        return list;
    }

}

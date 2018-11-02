package com.leetCode;

import java.util.Stack;
/**
 * 
 * <p>Title:ReverseInteger</p>
 * <p>Description: </p>
 * @auther Administrator
 * @data 2018年2月7日 上午11:12:39
 */
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(1534236469));
	}
	public static int reverse(int x) {
//		if (x == 0) return 0;
//        Stack<Character> s = new Stack<>(); 
//        StringBuffer str = new StringBuffer(x + "");
//        StringBuffer ans = new StringBuffer();
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '-') ans.append(str.charAt(i));
//            else s.push(str.charAt(i));
//        }
//        while (!s.isEmpty() && s.peek() == '0')
//            s.pop();
//        while (!s.isEmpty()) {
//        	char ch = s.pop();
//            ans.append(ch);
//        }
//        System.out.println(ans.toString());
//        long res = Long.valueOf(ans.toString());
//        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
//        else return (int)res;
		 	long res = 0;
	        do {
	            res = 10 * res + x % 10;
	            x = x / 10;
	        }
	        while (x != 0);
	        
	        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
	        else return (int)res;
    }

}

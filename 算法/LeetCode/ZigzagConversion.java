package com.leetCode;
import java.util.Arrays;
/**
 * 
 * <p>Title:ZigzagConversion</p>
 * <p>Description: </p>
 * @auther Administrator
 * @data 2018年2月6日 下午7:52:49
 */
public class ZigzagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 3));
	}
	
	public static String convert(String s, int numRows) {
//		System.out.println("length:" + s.length());
		if (s == "") return "";
		if (s == null) return null;
        char[][] ans = new char[numRows][((s.length() / (numRows * 2 - 2)) + 1) * (numRows - 1)];
//        System.out.println("numRows:" + ans.length + "  column:" + ans[0].length);
        for (int i = 0; i < ans.length; i++)
        	Arrays.fill(ans[i], ' ');
        
        for (int i = 0; i < s.length(); i++) {
            int q = numRows * 2 - 2;
            int k = i / q;
            int p = i % q;
            if (p < numRows && p >= 0) ans[p][(numRows - 1) * k] = s.charAt(i);
            else ans[2 * numRows - p - 2][k * (numRows - 1) + p -numRows + 1] = s.charAt(i);
        }
        
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < ans.length; i++)
            for (int j = 0; j < ans[0].length; j++)
                if (ans[i][j] == ' ')
                    continue;
                else
                    res.append(ans[i][j]);
//        System.out.println("PAHNAPLSIIGYIR".equals(res.toString()) + " " + res.toString().length());
//        System.out.println(res.toString().length());
        return res.toString();
        
        
    }

}

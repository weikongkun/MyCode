package com.leetCode;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *@ClassName: E93_RestoreIPAddress
 *@Description: 未通过
 *@date：      2018年5月15日 下午9:58:50
 */
public class E93_RestoreIPAddress {
	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));
	}
	public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0 || s == null || s.length() > 12) return res;
        combination(new StringBuilder(), s, 0, 0, res);
        return res;
    }
	
	public static void combination(StringBuilder sb, String s, int pre, int sub, List<String> res) {
		if (sb.length() == s.length() + 4 && sub == 4) {
			res.add(sb.deleteCharAt(sb.length() - 1).toString());
			return;
		}
		if (sb.length() < s.length() + 4 &&  sub >= 4) return;
		
		for (int i = 1; i <= 3; i++) {
			if (sb.length() - sub + i > s.length()) break;
			int num = Integer.parseInt(s.substring(pre, pre + i));
			if (num < 256) {
				sb.append(num + '.');
				combination(sb, s, pre + i, sub + 1, res);
				sb.delete(sb.length() - i - 1, sb.length());
			}
				
		}
	}
}

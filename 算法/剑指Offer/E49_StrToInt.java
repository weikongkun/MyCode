package com.JianZhiOffer;

public class E49_StrToInt {
	public static void main(String[] args) {
		System.out.println(strToInt("+"));
	}
	public static int strToInt(String str) {
		if (str == null || str.length() == 0) return 0;
        char[] charArray = str.toCharArray();
        int index = 0;
        while (charArray[index] == ' ') index++;
        boolean postive = true;
        if (charArray[index] == '+') index++;
        else if (charArray[index] == '-') {
        	index++;
        	postive = false;
        }
        int res = 0;
        while (index < charArray.length) {
        	if (charArray[index] >= '0' && charArray[index] <= '9') {
        		res = res * 10 + (charArray[index] - '0');
        	}
        	else return 0;
        	index++;
        }
        if (postive) return res;
        else return 0 - res;
    }
}

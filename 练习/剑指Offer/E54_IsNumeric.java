package com.JianZhiOffer;

public class E54_IsNumeric {
	public boolean isNumeric(char[] str) {
		if (str == null)
	        return false;
	    return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }
}

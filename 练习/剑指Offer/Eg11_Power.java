package com.JianZhiOffer;

public class Eg11_Power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Power1(0, 0));
	}
	
	public static double Power1(double base, int exponent) {
        if (base ==  0 && exponent < 0) {
            return 0.0;
        }
        double result = 1.0;
        for (int i = 1; i <= Math.abs(exponent); i++)
        	result *= base;
        if (exponent < 0) return 1.0 / result;
        
        return result;
	}

}

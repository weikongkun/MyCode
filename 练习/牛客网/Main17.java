package com.NK;

import java.util.Scanner;

public class Main17 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        boolean[] b = new boolean[N];
        for (int i = 0; i < N; i++)
            if (i + 1 == in.nextInt())
                b[i] = true;
        for (int i = 0; i < N; i++)
        	System.out.print(b[i]);
        int k = -5;
        int count = 0;
        int index = 0;
        while (index < N) {
            if (b[index] && k != index - 1) {
            	count++;
            	k = index;
            	index++;
            	
            }
            else {
            	index++;
            }
        }
        System.out.println(count);
        in.close();
    }
}

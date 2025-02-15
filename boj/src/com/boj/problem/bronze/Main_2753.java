package com.boj.problem.bronze;

import java.util.Scanner;

public class Main_2753 {
	static int Y, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		
		if(((Y%4 == 0) && (Y%100 != 0)) || Y%400 == 0) result=1;
		
		System.out.print(result);
	}

}

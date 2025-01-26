package com.boj.problem.bronze;
import java.util.Scanner;

public class Main_2444 {
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < Math.abs(i-n/2); j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < n-2*Math.abs(i-n/2); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}

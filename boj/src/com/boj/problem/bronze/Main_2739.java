package com.boj.problem.bronze;

import java.util.Scanner;

public class Main_2739 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		
		for (int i = 1; i <= 9; i++) {
			sb.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
		}
		
		System.out.print(sb);
	}

}

package com.boj.problem.gold;

import java.util.Scanner;

public class Main_2448 {
	static int N;
	static int[][] board;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		board = new int[N][2*N-1];
		sb = new StringBuilder();
		
		star(0, 0, N);
	}

	private static void star(int r, int c, int n) {
		if(n == 3) {
			for (int i = 0; i < 3; i++) {
				아직 하는 중
			}
		}
	}

}

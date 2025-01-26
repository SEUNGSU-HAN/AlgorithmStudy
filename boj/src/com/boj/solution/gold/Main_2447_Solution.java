package com.boj.solution.gold;

import java.util.Scanner;

public class Main_2447_Solution {
	static int n;
	static int[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		board = new int[n][n];
		
		StringBuilder sb = new StringBuilder();
		
		//로직
		star(0, 0, n);
		
		//출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(board[i][j] == 1) sb.append("*");
				else sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void star(int r, int c, int n) {
		if(n == 3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					//중앙 파악
					if(i == 1 && j == 1) continue;
					board[r+i][c+j] = 1;
				}
			}
		}else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					//중앙 파악
					if(i == 1 && j == 1) continue;
					star(r+i*n/3, c+j*n/3, n/3);
				}
			}
		}
		
	}
}

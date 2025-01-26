package com.boj.solution.gold;

import java.util.Scanner;

//강사님 코드도 오류 발생 (int 배열 써서 그런듯)
//로직은 맞는 로직
public class Main_2448_Solution {
	static int n;
	static int[][] board;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		board = new int[n][2*n-1];
		
		StringBuilder sb = new StringBuilder();
		
		//로직
		star(0, 0, n);
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2*n-1; j++) {
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
				for (int j = 0; j < 5; j++) {
					if(i == 0 && j == 2) {
						board[r+i][c+j] = 1;
					}else if(i == 1 && (j == 1 || j == 3)) {
						board[r+i][c+j] = 1;
					}else if(i == 2) {
						board[r+i][c+j] = 1;
					}
				}
			}
		}else {
			star(r+0, c+n/2, n/2);
			star(r+n/2, c+0, n/2);
			star(r+n/2, c+n, n/2);
		}
	}

}

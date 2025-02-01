package com.boj.problem.gold;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_9663 {
	static int N;
	static int[][] board;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static ArrayList<Integer> rDiagonal;
	static ArrayList<Integer> lDiagonal;
	static int count;
	
	public static void main(String[] args) {
		/* 입력 */
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		/* 초기화 */
		board = new int[N][N];
		rDiagonal = new ArrayList<>();
		lDiagonal = new ArrayList<>();
		
		/* 로직 */
		queen(0, 1);

		
		/* 출력 */
		System.out.println(count);
	}

	private static void queen(int r, int q) {
		//퀸을 모두 놓았을 때
		if(q == N) return;
		
		if(!rDiagonal.contains(Math.abs(r-c)) && !lDiagonal.contains(r+c)) {
			board[r][c] = 1; //퀸 배치
			rDiagonal.add(Math.abs(r-c));
			lDiagonal.add(r+c);
		}
		
		for (int c = 0; c < N; c++) {
			if(isValid(r, c)) {
				
			}
		}
		
	}
}

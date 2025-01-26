package com.boj.problem.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//int 2차원 배열이 메모리 다 잡아 먹어서 틀렸던 듯
//char로 바꾸니까 해결됬음
//+) Scanner -> BufferedReader, 재귀 중 n==3일 때 for -> 단순 대입, 출력 이중 for -> 단일 for 변경
public class Main_2448 {
	static int N;
	static char[][] board;

	public static void main(String[] args) throws Exception{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//초기화
		board = new char[N][2*N-1];
		Arrays.stream(board).forEach(i -> Arrays.fill(i, ' '));
		
		//로직
		star(0, N-1, N);
		
		//출력
		StringBuilder sb = new StringBuilder();

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < 2*N-1; j++) {
//				if(board[i][j] == 1) sb.append("*");
//				else sb.append(" ");
//			}
//			sb.append("\n");
//		}
		
		for (int j = 0; j < N; j++) {
			sb.append(board[j]).append('\n');
		}
		
		System.out.println(sb.toString());
	}

	private static void star(int r, int c, int n) {
		if(n == 3) {
//			for (int i = 0; i < n; i++) {
//				for (int j = c-i; j <= c+i ; j++) {
//					if(i == r+1 && j == c) continue;
//					board[r+i][j] = 1;
//				}
//			}
			board[r][c] = '*';
			board[r+1][c-1] = board[r+1][c+1] = '*';
			board[r+2][c-2] = board[r+2][c-1] = board[r+2][c] = board[r+2][c+1] = board[r+2][c+2] = '*';
			
			return;
		}
		int size = n/2;
		star(r, c, size); //상
		star(r+size, c-size, size); //좌
		star(r+size, c+size, size); //우
		
	}

}

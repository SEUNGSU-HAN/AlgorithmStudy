package com.boj.problem.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10993 {
	static int N;
	static char[][] board;
	
	public static void main(String[] args) throws Exception{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		//초기화
		int rSize = 1;
		int cSize = 1;
		if(N > 1) {
			rSize = (int)Math.pow(2, N)-1;
			for (int i = 2; i <= N; i++) {
				cSize += (int)Math.pow(2, i);
			}
		}
		board = new char[rSize][cSize];
		Arrays.stream(board).forEach(i -> Arrays.fill(i, ' '));
		
		//로직
		triangle((N%2 == 1) ? 0 : rSize-1, cSize/2, rSize, cSize, N);
		하는중
		//출력
		System.out.println(sb.toString());
	}

	private static void triangle(int r, int c, int rs, int cs, int n) {
		if(n == 1) {
			board[r][c] = '*';
			return;
		}
		//n -> 홀수: up, 짝수: down
		//(up: 삼각형 그림, down: 역삼각형)
		if(n%2 == 1) {
			for (int i = r; i < r+(rs-1); i++) {
				if(i != r+(rs-2)) {
					//별 + 공백
					for (int j = 0; j < 2*i+1; j++) {
						if(j == 0) board[r+i][c-j/2] = '*';
						else if(j == 2*i) board[r+i][c+j/2] = '*';
					}
				}else {
					//all 별
					for (int j = c-cs/2; j <= c+cs/2; j++) {
						board[i][j] = '*';
					}
				}
			}
		}else {
			for (int i = r; i >= r-(rs-1); i--) {
				if(i != r-(rs-1)) {
					//별 + 공백
					for (int j = 0; j < 2*i+1; j++) {
						if(j == 0) board[r-i][c-j/2] = '*';
						else if(j == 2*i) board[r-i][c+j/2] = '*';
					}
				}else {
					//all 별
					for (int j = c-cs/2; j <= c+cs/2; j++) {
						board[i][j] = '*';
					}
				}
			}
		}
	}

}

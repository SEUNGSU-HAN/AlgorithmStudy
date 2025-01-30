package com.boj.problem.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main_10993 {
	static int N;
	static char[][] board;
	
	출력 형식 오류... (아마 별 오른쪽 공백때문에 그런듯..?)
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
		
		//출력
		for (int j = 0; j < rSize; j++) {
			sb.append(board[j]).append('\n');
		}
		System.out.println(sb.toString());
	}

	private static void triangle(int r, int c, int rs, int cs, int n) {
		if(n == 1) {
			board[r][c] = '*';
			return;
		}
		//n -> 홀수: up, 짝수: down
		//(up: 삼각형 그림, down: 역삼각형)
		if(n%2 == 0) {
			for (int i = 0; i < rs; i++) {
				if(i != rs-1) {
					//사이드 별
					board[r-i][c+i] = '*';
					board[r-i][c-i] = '*';
				}else {
					//all 별
					for (int j = cs/2; j >= 0; j--) {
						board[r-i][c+j] = '*';
						board[r-i][c-j] = '*';
					}
				}
			}
			triangle(r-(rs-2), c, rs/2, cs/2-1, n-1);
		}else {
			for (int i = 0; i < rs; i++) {
				if(i != rs-1) {
					//사이드 별
					board[r+i][c+i] = '*';
					board[r+i][c-i] = '*';
				}else {
					//all 별
					for (int j = cs/2; j >= 0; j--) {
						board[r+i][c+j] = '*';
						board[r+i][c-j] = '*';
					}
				}
			}
			triangle(r+(rs-2), c, rs/2, cs/2-1, n-1);
		}
		
		
		
//		if(n%2 == 1) {
//			for (int i = r; i < r+(rs-1); i++) {
//				if(i != r+(rs-1)) {
//					//별 + 공백
//					for (int j = 0; j < 2*i+1; j++) {
//						if(j == 0) board[r+i][c-j/2] = '*';
//						else if(j == 2*i) board[r+i][c+j/2] = '*';
//					}
//				}else {
//					//all 별
//					for (int j = c-cs/2; j <= c+cs/2; j++) {
//						board[i][j] = '*';
//					}
//				}
//			}
//		}else {
//			for (int i = r; i >= r-(rs-1); i--) {
//				if(i != r-(rs-1)) {
//					//별 + 공백
//					for (int j = 0; j < 2*i+1; j++) {
//						if(j == 0) board[r-i][c-j/2] = '*';
//						else if(j == 2*i) board[r-i][c+j/2] = '*';
//					}
//				}else {
//					//all 별
//					for (int j = c-cs/2; j <= c+cs/2; j++) {
//						board[i][j] = '*';
//					}
//				}
//			}
//		}
	}

}

package com.boj.problem.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2615 {
	static int N = 19;
	static int[][] board;
	static int[] dr = {0, -1, -1, -1};
	static int[] dc = {1, 1, 0, -1};
	static int[] pdr = {0, 1, 1, 1};
	static int[] pdc = {-1, -1, 0, 1};
	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/* 초기화 */
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/* 로직 */
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				int stoneCount = 0;
				if(board[r][c] == 1) { //검정
					stoneCount++;
					for (int k = 0; k < 4; k++) {
						int pr = r+pdr[k];
						int pc = c+pdc[k];
						int nr = r+dr[k];
						int nc = c+dc[k];
						while(check(nr, nc, 1)) {
							하는중
						}
					}
				}else if(board[r][c] == 2) { //흰색
					
				}
			}
		}
		/* 출력 */
	}

	private static boolean check(int nr, int nc, int stone) {
		if((0 <= nr && nr < N) 
				&& (0 <= nc && nc < N) 
				&& board[nr][nc] == stone) 
			return true;
		return false;
	}

}

package com.boj.problem.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2615 {
	static int N = 19;
	static int[][] board;
	static int[] dr = {0, 1, 1, 1};
	static int[] dc = {1, 1, 0, -1};
	static int[] pdr = {0, -1, -1, -1};
	static int[] pdc = {-1, -1, 0, 1};
	static int winner = 0;
	static int[][] winStone;
	
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
		winStone = new int[2][2];
		
		/* 로직 */
		loop:
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				winStone[0][0] = r;
				winStone[0][1] = c;
				if(board[r][c] == 1) { //검정
					int stoneCount = 1;
					for (int k = 0; k < 4; k++) {
						int pr = r+pdr[k];
						int pc = c+pdc[k];
						int nr = r+dr[k];
						int nc = c+dc[k];
						if(check(pr, pc) && board[pr][pc] == 3) continue;
						while(check(nr, nc) && board[nr][nc] == 1) {
							stoneCount++;
							winStone[1][0] = nr;
							winStone[1][1] = nc;
							nr += dr[k];
							nc += dc[k];
						}
						if(stoneCount == 5) {
							winner = 1;
							break loop;
						}else {
						    stoneCount = 1;
						}
					}
					board[r][c] = 3;
				}else if(board[r][c] == 2) { //흰색
					int stoneCount = 1;
					for (int k = 0; k < 4; k++) {
						int pr = r+pdr[k];
						int pc = c+pdc[k];
						int nr = r+dr[k];
						int nc = c+dc[k];
						if(check(pr, pc) && board[pr][pc] == 4) continue;
						while(check(nr, nc) && board[nr][nc] == 2) {
							stoneCount++;
							winStone[1][0] = nr;
							winStone[1][1] = nc;
							nr += dr[k];
							nc += dc[k];
						}
						if(stoneCount == 5) {
							winner = 2;
							break loop;
						}
						else stoneCount = 1;
					}
					board[r][c] = 4;
				}
			} 
		}
		/* 출력 */
		StringBuilder sb = new StringBuilder();
		if(winner == 0) sb.append(winner);
		else {
			if((winStone[1][1] - winStone[0][1]) < 0)
				sb.append(winner).append("\n").append(winStone[1][0]+1).append(" ").append(winStone[1][1]+1);
			else
				sb.append(winner).append("\n").append(winStone[0][0]+1).append(" ").append(winStone[0][1]+1);
		}
		System.out.println(sb.toString());
	}

	private static boolean check(int nr, int nc) {
		if((0 <= nr && nr < N) 
				&& (0 <= nc && nc < N)) 
			return true;
		return false;
	}

}

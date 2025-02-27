package com.swea.sw.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_프로세서_연결하기 {
	static int T, N;
	static int[][] board;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<int[]> core;
	static boolean[] visited;
	static int maxCore;
	static int maxLine;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		
		for (int t = 0; t < T; t++) {
			/* 입력 */
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			/* 초기화 */
			board = new int[N+2][N+2];
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					board[i][j] = 4;
				}
			}
			core = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if(board[i][j] == 1) {
						if((i == 1 || i == N) || (j == 1 || j == N)) {
							maxCore++;
							board[i][j] = 3;
						}
						else core.add(new int[] {i, j});
					}
				}
			}
			visited = new boolean[core.size()];
			maxLine = N*N;
			/* 로직 */
			//0: 전선 놓을 수 있는 곳
			//1: 전선 연결 안된 CPU
			//2: 전선 및 전류 표시
			//3: 연결 완료된 CPU
			dfs(0, maxCore, 0, deepCopyBoard(board));
			
			/* 출력 */
			System.out.println("maxCore: " + maxCore);
			for (int i = 0; i < N+2; i++) {
				for (int j = 0; j < N+2; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}

	private static int[][] deepCopyBoard(int[][] s) {
		int[][] d = new int[N+2][N+2];
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < N+2; j++) {
				d[i][j] = s[i][j];
			}
		}
		
		return d;
	}

	private static void dfs(int cnt, int connCore, int connLine, int[][] tempBoard) {
		if(cnt == core.size()) {
			int maxC = Math.max(maxCore, connCore);
			int minL = Math.min(maxLine, connLine);
			if(maxCore < maxC && maxLine > minL) {
				maxCore = maxC;
				maxLine = minL;
				board = deepCopyBoard(tempBoard);
			}
			return;
		}
		int[][] initBoard = deepCopyBoard(tempBoard);
		int[] cur = core.get(cnt);
		//1. 해당 코어 주변에 전류가 흐르는지 check
		for (int i = 0; i < 4; i++) {
			int nr = cur[0]+dr[i];
			int nc = cur[1]+dc[i];
			int count = 0;
			while(check(nr, nc)) {
				if(tempBoard[nr][nc] != 0) {
					tempBoard = deepCopyBoard(initBoard);
					break;
				}
				tempBoard[nr][nc] = 2;
				count++;
				nr += dr[i];
				nc += dc[i];
				if(tempBoard[nr][nc] == 4) {
					dfs(cnt+1, connCore+1, connLine+count, deepCopyBoard(tempBoard));
				}
			}
		}
	}

	private static boolean check(int nr, int nc) {
		if((1 <= nr && nr <= N) && (1 <= nc && nc <= N)) return true;
		return false;
	}

}

package com.boj.problem.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3109 {
	static int R, C;
	static char[][] board;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1};
	static int pipe;

	public static void main(String[] args) throws Exception{
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		//초기화
		board = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(board[i][j] == 'x') visited[i][j] = true;
			}
		}
		
		
		//로직
		for (int i = 0; i < R; i++) {
			dfs(0, new int[] {i, 0});
		}
		
		for (int i = 0; i < R; i++) {
			if(board[i][C-1] == 'a') pipe++;
		}
		
		//출력
		System.out.println(pipe);
		
	}

	static void dfs(int cnt, int[] cur) {
		if(cnt == C) {
			return;
		}
		for (int i = 0; i < 3; i++) {
			int nr = cur[0]+dr[i];
			int nc = cur[1]+1;
			if(check(nr, nc) && board[nr][nc] == '.' )
		}
	}

	static boolean check(int nr, int nc) {
		return (0 <= nr && nr < R) && (0 <= nc && nc < C);
	}

}

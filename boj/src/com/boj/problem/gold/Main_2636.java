package com.boj.problem.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {
	static int N, M;
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<int[]> cheese;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		board = new int[N][M];
		visited = new boolean[N][M];
		cheese = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) cheese.add(new int[] {i, j});
			}
		}
		
		/* 로직 */
		bfs(0);
		
		/* 출력 */
		StringBuilder sb = new StringBuilder();
		System.out.println(sb);
	}

	private static void bfs(int start) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(cheese.get(start));
		visited[cheese.get(0)[0]][cheese.get(0)[1]] = true;
		while(!q.isEmpty()) {
			int[] coord = q.poll();
			int r = coord[0];
			int c = coord[1];
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(check(nr, nc)) {
					사이드 치즈 판별을 생각해야함..
				}
			}
		}
	}

	private static boolean check(int nr, int nc) {
		if((0 <= nr && nr < N) && (0 <= nc && nc < M)
				&& board[nr][nc] == 0)
		return false;
	}

}


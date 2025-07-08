package com.boj.problem.gold;
import java.io.*;
import java.util.*;

public class Main_7576_re {
	static int N, M, pre_tomato, day;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception{
		/* 입력 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		/* 초기화 */
		board = new int[N][M];
		visited = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) pre_tomato++;
				else if(board[i][j] == 1) {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}

		/* 로직 */
		while(!q.isEmpty()) {
			int n = q.size();
			while(n-- > 0) {
				int[] cur = q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = cur[0]+dr[i];
					int nc = cur[1]+dc[i];
					if(check(nr, nc) && !visited[nr][nc]) {
						if(board[nr][nc] == -1) continue;
						q.offer(new int[] {nr, nc});
						visited[nr][nc] = true;
						pre_tomato--;
					}
				}
			}
			day++;
		}

		/* 출력 */
		System.out.println(pre_tomato == 0 ? day-1 : -1);
	}

	static boolean check(int nr, int nc) {
		return (nr >= 0 && nr < N) && (nc >= 0 && nc < M);
	}

}
